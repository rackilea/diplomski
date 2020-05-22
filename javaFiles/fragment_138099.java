public class DaggerInjector {

    private static YourComponent component;

    private DaggerInjector() {
        super();
    }

    public static YourComponent getComponent() {
        return component;
    }

    public static YourComponent buildComponent(Context context) {
        component = DaggerYourComponent
                .builder()
                .yourModule(new YourModule(context))
                .build();
        return component;
    }
}