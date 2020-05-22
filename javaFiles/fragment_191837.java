class A {
    int xyz = new B().show(); // prints c=0 and z=null
    int c = -319;
    B z = new B();
    int lmn = z.show(); // prints c=-319

    class B {
        int show() {
            System.out.println("c=" + c);
            System.out.println("z=" + z);
            return -555;
        }
    }
}