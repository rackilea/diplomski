HostClass {
    doSomething() {}

    class Inner {
        void blah() {
            HostClass.this.doSomething();
        }
    }
}