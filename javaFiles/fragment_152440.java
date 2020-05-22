private static <T> void helper(CalledInterface<T> c) {
    T element = c.get();
    c.set(element);
}
public void run(){
    helper(c);
}