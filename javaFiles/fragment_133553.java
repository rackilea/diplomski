private static class C extends BrokenGenerics<A> {

    public C(A... initArray) {
        super(initArray);
    }

    public void printFirst() {
        A[] result = genericTypeArray; // ClassCastException here!
        System.out.println(result[0]);
    }
}