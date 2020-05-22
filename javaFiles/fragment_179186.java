public class Outer {
    private String s;

    public void setS(String s) {
        this.s = s;
    }

    public class Inner {
        public String getOuterS() {
            // This is legal only if Inner is
            // non-static and nested in Outer
            return s;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Outer o = new Outer();
        o.setS("Hello world!!!");

        // i now has access to every o member
        Outer.Inner i = o.new Inner();

        // Prints "Hello world!!!"
        System.out.println(i.getOuterS());
    }
}