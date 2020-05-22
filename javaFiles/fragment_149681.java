@SuppressWarnings("unchecked")
private static <T extends Marker> void captureHelper(Class<T> clazz,
        Pair<A, ? extends Marker> p, ClassToHandlerMap dispatch) {
    Pair<A, T> p1 = (Pair<A, T>)p;

    Handler<T> h1 = dispatch.get(clazz);
    h1.handle(p1);
}