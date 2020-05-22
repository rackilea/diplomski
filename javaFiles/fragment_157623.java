public class Test<T> {

    T var;

    public static void main(String[] args) {
        Test<Integer> a = new Test<Integer>();
        System.out.println(a.boo());
        a.setVar(new Integer(10));
        System.out.println(a.boo());
    }

    public String boo() {
        if (var == null) {
            return "Don't know yet";
        }
        return var.getClass().getSimpleName();
    }

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar() {
        return var;
    }
}