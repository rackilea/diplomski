public class ThirdPartyModule extends AbstractModule {
    @Override
    protected void configure() {
        // CoolWidget --
        //              \
        //               > WidgetInterface -> DefaultWidgetImpl
        //              /
        // AwesomeWidget

        OptionalBinder.newOptionalBinder(binder(), WidgetInterface.class)
                .setDefault()
                .to(DefaultWidgetImpl.class);

        bind(CoolWidget.class).to(WidgetInterface.class);
        bind(AwesomeWidget.class).to(WidgetInterface.class);
        // etc.
    }
}

public class MyAppModule extends AbstractModule {
    @Override
    protected void configure() {
        OptionalBinder.newOptionalBinder(binder(), WidgetInterface.class)
                .setBinding()
                .to(CustomWidgetImpl.class);
    }
}