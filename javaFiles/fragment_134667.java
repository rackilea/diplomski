@Provides
provideA(B b) {
    A a = new A();
    a.setB(b);
    a.doMoreInitializationThatMustBeDoneNow();
    return a;
}