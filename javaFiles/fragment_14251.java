class Main {
    public static void main(String[] args) {
        System.out.print(SomeClass.Inner);
    }
}

class SomeClass{
    private static class Inner {
        public static int a = 1;
    }

}