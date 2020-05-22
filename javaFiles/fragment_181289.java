package com.reactive;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.TestScheduler;
import rx.subjects.BehaviorSubject;
import sun.jvm.hotspot.utilities.Assert;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


// According to https://github.com/ReactiveX/RxJava/wiki/Implementing-Your-Own-Operators#transformational-operators
// you should use transformers to implement your own observables
class Watcher implements Observable.Transformer<String,String> {

    Scheduler _scheduler;

    // As you already realized in your answer you need to specify the scheduler if you want to control the interval observable
    public Watcher(Scheduler scheduler) {
       _scheduler = scheduler;
    }

    @Override
    public Observable<String> call(Observable<String> retriever) {
        return retriever.switchMap(s ->
                // Create the sequence of ticks
            Observable.interval(1,TimeUnit.SECONDS,_scheduler)
            .map(tick -> "tick " + tick)
            // but prepend the actual signal from the retriever
            .startWith(s)
            );
    }
}


public class Main {

    public static void main(String[] args) {

        TestScheduler testScheduler = new TestScheduler();
        BehaviorSubject<String> retriever = BehaviorSubject.create();

        ArrayList<String> results = new ArrayList<>();
        retriever.compose(new Watcher(testScheduler))
                .subscribe(s->results.add(s));

        retriever.onNext("A");
        retriever.onNext("B");
        testScheduler.advanceTimeBy(3, TimeUnit.SECONDS);
        retriever.onNext("C");
        testScheduler.advanceTimeBy(2, TimeUnit.SECONDS);

        String result = String.join(" , ",results);
        Assert.that(result.equals("A , B , tick 0 , tick 1 , tick 2 , C , tick 0 , tick 1"),result);
    }
}