public class Poly1 {
    public void f() {
        System.out.println("1f");
        g();
    }

    public void g() {
        System.out.println("1g");
        h((byte) 10); // cast to byte to invoke the overloaded method void
                      // h(byte b)
    }

    protected void h(int i) {
        System.out.println("1hi");
    }

    void h(byte b) {
        System.out.println("1hb");
    }
}


public class Poly2 extends Poly1 {

     public void f() { //change from protected  to public since the visibility of an overidden method Cannot be reduced
        System.out.println("2f");
        Poly1 c = new Poly1();
        c.g(); // invoke the methode g of Poly1
        h((byte) 10);
    }

    public void g() {
        System.out.println("2g");
        h(18);
    }

    protected void h(int i) {
        System.out.println("2hi");
}

    public void h(byte b) {
        System.out.println("2hb");
    }
}