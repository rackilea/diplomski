class Outer {
    class Inner {
        @Override
        public String toString() {
            return String.format("#<Inner[%h] outer=%s>", this, Outer.this);
        }
    }

    @Override
    public String toString() {
        return String.format("#<Outer[%h]>", this);
    }

    public Inner newInner() {
        return new Inner();
    }

    public Inner newInnerReflect() throws Exception {
        return Inner.class.getDeclaredConstructor(Outer.class).newInstance(this);
    }

    public static void main(String[] args) throws Exception {
        Outer outer = new Outer();
        System.out.println(outer);
        System.out.println(outer.newInner());
        System.out.println(outer.newInnerReflect());
        System.out.println(outer.new Inner());
        System.out.println(Inner.class.getDeclaredConstructor(Outer.class).newInstance(outer));
    }
}