class A {

    int xyz = 0;    //default values
    int c = 0;      //
    B z = null;     //
    int lmn = 0;    //

    A(){
        xyz = new B().show(); 
        c = -319;
        z = new B();
        lmn = z.show(); 
    }
    class B {
        int show() {
            System.out.println("c=" + c);
            System.out.println("z=" + z);
            return -555;
        }
    }
}