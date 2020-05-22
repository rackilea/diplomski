class D extends A {
    D() {
        super(false);
    }

    //You can also overload it so that you will have a choice
    D(boolean b) {
        super(b);
    }


    @Override
    public boolean getB() {
        return b;
    }

    public static void main(String[] args) {
        D defaultBVal = D();
        D customBVal = D(true);

        System.out.println(defaultBVal.getB()); //false
        System.out.println(customBVal.getB()); //true
    }
}