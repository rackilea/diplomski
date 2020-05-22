public synchronized ApplicationComponent getComponent() {
        if(component == null) {
            component = DaggerApplicationComponent.builder()
                    .networkModule(new NetworkModule())
                    .ApplicationModule(new ApplicationModule(this))
                    .build();
        }
        return component;
    }