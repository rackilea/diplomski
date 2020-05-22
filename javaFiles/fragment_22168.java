class C<T extends A> {

    public void function(T param) {
        // ...
    }

}

class D<T extends B> extends C<T> {

    @Override
    public void function(T param) {
        // ...
    }

}