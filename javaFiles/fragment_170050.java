class Outer {
    interface Inner {}

    Inner inner = new Inner() {
        {
            System.out.println(Outer.this);
        }
    };
}