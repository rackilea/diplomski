interface ListLike<any T> {
    // New methods added to the generic layer
    void removeByValue(T element);
    void removeByIndex(int pos);

    layer<ref T> {
        // Abstract methods that exist only in the ref layer
        void remove(int pos);
        void remove(T element);

        // Default implementations of the new generic methods
        default void removeByIndex(int pos) { remove(pos); }
        default void removeByValue(T t) { remove(t); }
    }
}