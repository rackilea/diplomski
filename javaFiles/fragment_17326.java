@Generated("dagger.internal.codegen.ComponentProcessor")
public final class ActivityModule_ProvideSignInViewFactory implements Factory<SignInView> {
  private final ActivityModule module;

  public ActivityModule_ProvideSignInViewFactory(ActivityModule module) {  
    assert module != null;
    this.module = module;
  }
  @Override
  public SignInView get() {  
    SignInView provided = module.provideSignInView();
    if (provided == null) {
      throw new NullPointerException("Cannot return null from a non-@Nullable @Provides method");
    }
    return provided;
  }

  public static Factory<SignInView> create(ActivityModule module) {  
    return new ActivityModule_ProvideSignInViewFactory(module);
  }
}