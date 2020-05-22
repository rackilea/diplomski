@ActivityScope //Dagger ignores the annotation put atop the @Component. I put it there just for readability
@Component(dependencies = DependencyGraph.class,
        modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
    void inject(SignUpActivity signUpActivity);
    void inject(SignInActivity signInActivity);