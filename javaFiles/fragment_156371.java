public class A {
    @Inject B; // either inject or assign in constructor
    @Inject C;
    @Inject D;

    public A(B listener) {
        AppComponent component = DaggerAppComponent.builder()
            .appModule(new AppModule(listener)) // now mandatory because of the non-default constructor
            .build();
        component.inject(this);
    }
}