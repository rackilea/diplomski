public void foo() {
    // Call the superclass implementation directly - no logging
    super.test();
}

@Override void test() {
    System.out.println("About to call super.test()");
    super.test();
    System.out.println("Call to super.test() complete");
}