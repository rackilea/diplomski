MainActivityComponent mainActivityComponent = 
    DaggerMainActivityComponent.builder()
        .mainActivityModule(new MainActivityModule())
        .contextModule(new ContextModule(this))
        .appComponent(App.getAppComponent())           // <-- this
        .build();
mainActivityComponent.inject(this);