import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.*;

import rx.*;
import rx.observers.TestSubscriber;
import rx.subjects.PublishSubject;
import rx.subscriptions.Subscriptions;

public final class SequenceSubscribers<T> implements Observable.OnSubscribe<T> {

    final Observable<? extends T> source;

    final Queue<Subscriber<? super T>> queue;

    final AtomicInteger wip;

    volatile boolean active;

    public SequenceSubscribers(Observable<? extends T> source) {
        this.source = source;
        this.queue = new ConcurrentLinkedQueue<>();
        this.wip = new AtomicInteger();
    }

    @Override
    public void call(Subscriber<? super T> t) {
        SubscriberWrapper wrapper = new SubscriberWrapper(t);
        queue.add(wrapper);

        t.add(wrapper);
        t.add(Subscriptions.create(() -> wrapper.next()));

        drain();
    }

    void complete(SubscriberWrapper inner) {
        active = false;
        drain();
    }

    void drain() {
        if (wip.getAndIncrement() != 0) {
            return;
        }
        do {
            if (!active) {
                Subscriber<? super T> s = queue.poll();
                if (s != null && !s.isUnsubscribed()) {
                    active = true;
                    source.subscribe(s);
                }
            }
        } while (wip.decrementAndGet() != 0);
    }

    final class SubscriberWrapper extends Subscriber<T> {
        final Subscriber<? super T> actual;

        final AtomicBoolean once;

        public SubscriberWrapper(Subscriber<? super T> actual) {
            this.actual = actual;
            this.once = new AtomicBoolean();
        }

        @Override
        public void onNext(T t) {
            actual.onNext(t);
        }

        @Override
        public void onError(Throwable e) {
            actual.onError(e);
            next();
        }

        @Override
        public void onCompleted() {
            actual.onCompleted();
            next();
        }

        @Override
        public void setProducer(Producer p) {
            actual.setProducer(p);
        }

        void next() {
            if (once.compareAndSet(false, true)) {
                complete(this);
            }
        }
    }

    public static void main(String[] args) {
        PublishSubject<Integer> ps = PublishSubject.create();

        TestSubscriber<Integer> ts1 = TestSubscriber.create();
        TestSubscriber<Integer> ts2 = TestSubscriber.create();

        Observable<Integer> source = Observable.create(new SequenceSubscribers<>(ps));

        source.subscribe(ts1);
        source.subscribe(ts2);

        ps.onNext(1);
        ps.onNext(2);

        ts1.assertValues(1, 2);
        ts2.assertNoValues();

        ts1.unsubscribe();

        ps.onNext(3);
        ps.onNext(4);
        ps.onCompleted();

        ts1.assertValues(1, 2);
        ts2.assertValues(3, 4);
        ts2.assertCompleted();
    }
}