class First {
    public First() {
        System.out.println("syso from first:");
        First.print();
    }

    public static void print() {
        System.out.println("FIRST");
    }
}
 class Second extends First{
    public static void main(String[] args) {
        new Second();
    }

    public Second() {
        System.out.println("syso from second:");
        Second.print();
    }


    public static void print() {
        First.print();
        System.out.println("SECOND");
    }
}