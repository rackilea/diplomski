class SomeClass{
    public SomeClass() { System.out.println("creating SomeClass object"); }
}

class StaticTest{
    static{ System.out.println("static block 1"); }
    static SomeClass sc = new SomeClass();
    static{ System.out.println("static block 2"); }

    public static void main(String[] args) {
        new StaticTest();
    }
}