public abstract class SuperClass<S extends SuperClass<S>> {

    public S intern() {
        return (S) this;
    }

    public static class SubClass extends SuperClass<SubClass> {

        private void methodOnlyInSubClass() {
            System.out.println("subclass method");
        }

        public void myMethod() {
            SubClass sub = intern();
            sub.methodOnlyInSubClass();
        }

    }

}