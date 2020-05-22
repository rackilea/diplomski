class Main {
    public static void main(String[] args) {
        System.out.print(SomeClass.Inner.a);
    }
}

class SomeClass{
    public static class Inner {
        private static int a = 1;  // If a is private, it produces an error above
      //public static int a = 1; // This would not be an error
    }
}