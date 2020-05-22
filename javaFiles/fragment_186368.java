public ApplicationComponent getComponent() {
    ApplicationComponent component = DaggerApplicationComponent.builder()
                .networkModule(new NetworkModule())
                .ApplicationModule(new ApplicationModule(this))
                .build();

    return component;
}