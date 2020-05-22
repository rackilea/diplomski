class TestClass {
    public Wrapper<String> foo = new Wrapper("foo");

    public void makeFooBar() {
        Wrapper<String> bar = foo;
        bar.set("bar");

        System.out.println(foo); //should print "bar"
    }

     public static class Wrappper<T>
    {
          T value;

         public Wrapper(T value)
         {
               this.value = value;
         }

         public T get() { return this.value; }
         public void set(T newValue) { this.value = newValue; }
         @override
         public String toString() { return value.toString(); }
    }
}