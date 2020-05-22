@RequestScoped
public class C1 {
    ...  
}

@SessionScoped
public class C2 {
    @Inject
    private Provider<C1> provider;
    ...
    public void doSomething() {
        // Get the instance corresponding to the current request
        C1 c1 = provider.get();
        ...
    }
}