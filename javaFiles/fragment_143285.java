interface Box<T> {
    public T get();
    public void put( T element);
}

class CaptureTest {
    public void rebox( Box<?> box) {
        box.get(); // return type of get() is a capture binding
    }
}