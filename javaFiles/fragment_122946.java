package impl;

public final class FriendlyAccessExample {
    public static void main(String[] args) {
        Accessor accessor = Accessor.getInstance();
        Exposed exposed = accessor.createExposed();
        accessor.sayHello(exposed);
    }
}