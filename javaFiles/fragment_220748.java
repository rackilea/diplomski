class Cons1 {
    static Cons1 c = new Cons1();

    Cons1() {
        System.out.println("the constructor was called");
    }

    public static void main(String[] args) {
        Cons1 c1 = new Cons1();
        Cons1 c2 = new Cons1();
    }
}