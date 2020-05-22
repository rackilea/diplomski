class Outer {
    Outer() {
    }

    class Inner {
        Inner() {
        }

        public Outer getOuter() {
            return Outer.this;
        }
    }

    void func() {
        System.out.println("Outer");
    }
}