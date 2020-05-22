Injector injector = Guice.createInjector(new PrivateModule() {
        @Override
        protected void configure() {
            bind(String.class).toInstance("one");
            bind(MainOne.class);

            expose(MainOne.class);
        }
    }, new PrivateModule() {
        @Override
        protected void configure() {
            bind(String.class).toInstance("two");
            bind(MainTwo.class);

            expose(MainTwo.class);
        }
    });