// singleton used by multiple threads
class A {

    public void method() {
        Set<String> codeSet = SomeRepo.someMethod(session.getUser()); // Heavy repo call.
        new AProcessor(codeSet).method();
   }
}

// not a singleton, only one thread uses an instance of this class
class AProcessor {
    private final Set<String> codeSet;

    AProcessor(Set<String> codeSet) {
        this.codeSet = codeSet;
    }

    public void method() {
        method1();
        method2();

        ....

        methodn();
   }

   private methodn() {
        codeSet.iterator().next(); 
   }
}