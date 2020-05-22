private static <T> void helper(CalledInterface<T> c) {
    c.set(c.get());
}
public void run(){
    helper(c);
}