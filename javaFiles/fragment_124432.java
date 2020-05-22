interface IView<T> {
    void renderObject(Object o);
    void render(T);
    T coerce(Object o);
}

abstract class ViewBase<T> implements IView<T> {
    void renderObject(Object o) {
        render(coerce(o));
    }
}

class FirstView extends ViewBase<One> {
    // …
}