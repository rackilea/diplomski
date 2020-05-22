public interface Blah<T> {
    void blah(T param);
}

public class Super implements Blah<Super> {
    public void blah(Super param) {}
}

public class Sub extends Super {
    public void blah(Super param) {}
   //Here you have to go with Super because Super is not paramaterized
   //to allow a Sub here and still be overriding the method.
}