public class Outer {
    void meth(){
        System.out.println("outer");
    }

    static Outer y = new Outer(){
        void meth(){
            System.out.println("anonymous");
        }
    };

    public static void main(String[] args) {
        Outer a = new Outer();
        a.meth();
        y.meth();
    }
}