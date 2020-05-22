class Base {

    public Base() {
        System.out.println("base");
    }
}

class Derived extends Base {

    public Derived() {
        //super(); call is not necessary.. Java code puts it here by default
        System.out.println("derived");
    }
}