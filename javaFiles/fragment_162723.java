class Test {
    static final int x;
    static {
        printX();
        x = 42;
        printX();
    }

    static void printX() {
        System.out.println("Here x is "+x);
    }
    public static void main(String[] args) { }
}