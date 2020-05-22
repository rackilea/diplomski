class C extends B {
    int xB = 4;

    C() {
        System.out.println(this.xB);
        System.out.println(super.xB);
        System.out.println(((B)this).xB); //same behavior as super.xB
        //System.out.println(B.xB); // Not allowed as xB is not static in B
    }
}