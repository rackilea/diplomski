interface InterfaceA {

   public <T> void doStuff( String paramA, Holder<T> holder );
}

class Holder<T> {

    public T t;
}