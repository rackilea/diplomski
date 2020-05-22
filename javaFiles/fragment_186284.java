@PerActivity
@Component(dependencies = {CoreComponent.class})
public interface ActivityComponent {
    void inject(FooActivity activity);

    void inject(BarActivity activity);
}