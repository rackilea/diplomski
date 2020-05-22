public class ObservableValue<T> {
    private static final String TAG = ObservableValue.class.getSimpleName();

    private ArrayList<Registration> subscriptions = new ArrayList<>();
    private T value;
    private int index;
    private boolean firstNotify;
    private ReentrantLock lock = new ReentrantLock();

    public ObservableValue() {
        firstNotify = false;
    }

    public ObservableValue(T defaultValue) {
        value = defaultValue;
        firstNotify = true;
    }

    @SuppressWarnings("unchecked")
    public void setValue(T value) {
        lock.lock();
        this.value = value;
        for (Registration listener: subscriptions) {
            if (!listener.isFinished()) {
                listener.getListener().valueChanged(value);
            }
        }
        lock.unlock();
    }

    public T getValue() {
        lock.lock();
        T result = value;
        lock.unlock();
        return result;
    }

    public Registration subscribe(ValueChangeListener<T> listener) {
        lock.lock();
        Registration s = new Registration(this, index, listener);
        index++;
        subscriptions.add(s);
        if (firstNotify||value!=null) {
            listener.valueChanged(value);
        }
        lock.unlock();
        return s;
    }

    protected void finish(int index) {
        lock.lock();
        for (int i=0;i<subscriptions.size();i++) {
            Registration s = subscriptions.get(i);
            if (s.getIndex()==index) {
                subscriptions.remove(i);
                break;
            }
        }
        lock.unlock();
    }
}

public abstract class ValueChangeListener<T> {
    private Looper looper;

    public ValueChangeListener() {}

    public ValueChangeListener(Looper looper) {
        this.looper = looper;
    }

    public void valueChanged(T data) {
        if (looper!=null) {
            Handler handler = new Handler(looper, msg -> {
                onValueChanged(data);
                return true;
            });
            handler.sendEmptyMessage(0);
        } else {
            onValueChanged(data);
        }
    }

    public abstract void onValueChanged(T data);
}

public class Registration {
    private ObservableValue observableValue;
    private int index;
    private ValueChangeListener listener;
    private volatile boolean finished = false;

    protected Registration(ObservableValue observableValue, int index, ValueChangeListener listener) {
        this.observableValue = observableValue;
        this.index = index;
        this.listener = listener;
    }

    protected ValueChangeListener getListener() {
        return listener;
    }

    protected int getIndex() {
        return index;
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish() {
        finished = true;
        observableValue.finish(index);
    }
}