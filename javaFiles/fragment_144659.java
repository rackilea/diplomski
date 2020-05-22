class MyClass extends Widget {
    ... // jave UI binder class

    public interface MyStyle extends CSSBundle {
        String someClassName();
    }

    @UiField
    MyStyle style;

    ...
    something.setClassName(style.someClassName());
    ...
}