public interface KeyFactory<K extends CharSequence> {
    public KeyBuilder<K> newBuilder();
}

public interface KeySequence<K extends CharSequence> {
    public KeySequence<K> append(char value);
    public K build();
}