public abstract class Key {
}

public abstract class Value {
}

public class ChildKey extends Key {

}
public class ChildValue extends Value {

}

public abstract class Result<K extends Key, V extends Value> {
    protected final K key;
    protected final V value;

    protected Result(K key, V value) {
        this.key = key;
        this.value = value;
    }
}

public class ChildResult extends Result<ChildKey, ChildValue> {

    public ChildResult(ChildKey key, ChildValue value) {
        super(key, value);
    }
}