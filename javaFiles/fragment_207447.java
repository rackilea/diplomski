class A<V> {

    public static class Container {

        public static class In<T> {

            public static class Inner<U> {
            }
        }

        public static <X> void doit() {
            new In.Inner<X>(); // compilation error
        }
    }
}