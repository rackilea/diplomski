@Component(
    modules = {MainActivityModule.class},
    dependencies = {AppComponent.class})      // <-- this
public interface MainActivityComponent {
  void inject(MainActivity mainActivity);
}