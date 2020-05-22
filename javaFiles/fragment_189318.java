class A {
    static volatile boolean finalized;

    Object b = new Object() {
        @Override protected void finalize() {
            System.out.println(this + " was finalized!");
            finalized = true;
        }
        @Override public String toString() {
            return  "B@"+Integer.toHexString(hashCode());
        }
    };
    @Override protected void finalize() {
        System.out.println(this + " was finalized!");
    }

    @Override public String toString() {
        return super.toString() + " with "+b;
    }

    public static void main(String[] args) {
        A a = new A();
        System.out.println("Created " + a);
        for(int i = 0; !finalized; i++) {
            if (i % 1_000_000 == 0)
                System.gc();
        }
        System.out.println("finalized");
    }
}