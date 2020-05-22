private static class Test {

    static {
        System.out.println(Test.k);
        k = 2;
        System.out.println(Test.k);
        }
    static int k = 1;

    public static void main(String[] args) {
        System.out.println(k);
    }
}