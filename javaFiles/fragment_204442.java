abstract class MyAbstractClass {
    int i; // some property
    private MyAbstractClass(int i) {
        this.i = i;
    }

    public static class InnerConcrete extends MyAbstractClass {
        int j; // some other property
        public InnerConcrete(int i, int j) {
            super(i);
            this.j = j;
        }
    }
}