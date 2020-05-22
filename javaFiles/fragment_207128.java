public class A {

    public class B<T> {
        public /* synthetic */ A A$B$$$outer() {
            return A.this;
        }

        public B() {
            if (A.this == null) {
                throw null;
            }
        }
    }

}