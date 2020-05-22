public class A {
    public String msg;
    private String msg1;

    public A(String mm, String mm1) {
        this.msg  = mm;
        this.msg1 = mm1;
    }

    public String msg1() {
        return(this.msg1);
    }

    @Override
    public String toString() {
        return(this.msg + " " + msg1());
    }
}

public class B extends A {
    public B() {
        super("A", "B");
    }

    @Override
    public String msg1() {
        return("C");
    }
}