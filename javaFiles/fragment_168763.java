public static void main(String[] args) {
    B bObj = new B();
    C cObj = new C(b.getObjA());

    System.out.println(cObj.getObjA().getA());
}