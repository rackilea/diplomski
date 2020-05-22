class Main {
    private static class Inner {
        public static int a = 1;
    }
    public static void main(String[] args) {
        System.out.print(Inner.a);
    }
}