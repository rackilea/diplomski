public class OuterClass {

    @Override
    public String toString() {
        return "I am the public outer class";
    }

    static class StaticInnerClass {
        @Override
        public String toString() {
            return "I am the package private inner class";
        }
    }

    class NonStaticInnerClass {
        @Override
        public String toString() {
            return "I am the package private non static inner class";
        }
    }

    public static void main(String[] args) {
        OuterClass oc = new OuterClass();
        OuterClass.StaticInnerClass ic = new OuterClass.StaticInnerClass();
        NonStaticInnerClass nsic = oc.new NonStaticInnerClass();
        System.out.println(oc);
        System.out.println(ic);
        System.out.println(nsic);
        System.out.println(new SecondClass());
    }
}

class SecondClass {
    @Override
    public String toString() {
        OuterClass oc = new OuterClass();
        OuterClass.StaticInnerClass ic = new OuterClass.StaticInnerClass();
        OuterClass.NonStaticInnerClass nsic = oc.new NonStaticInnerClass();
        return oc.toString() + "\n" + ic.toString() + "\n" + nsic.toString();
    }
}