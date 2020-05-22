public class a {
    public static void main(String[] args) {

        B b = new B();
        b.go();
    }
}

class B extends a{


    public void go(){

        System.out.println("hello");

    }
}