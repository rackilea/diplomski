final Supplier<View> myViewSupplier = Suppliers.memoize(new Supplier<View>() {
    @Override
    public View get() {
        return new View();
    }
});

...

public void myMethod() {
    View myView = myViewSupplier.get(); //lazy-loads when first called
    myView.makeVisible();
}