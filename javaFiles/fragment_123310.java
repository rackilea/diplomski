Injector injector = Guice.createInjector(new Module() {
        @Override
        public void configure(Binder binder) {
            @SuppressWarnings("rawtypes")
            Multibinder<Converter> converterBinder = Multibinder.newSetBinder(binder, Converter.class);
            converterBinder.addBinding().to(StringBooleanConverter.class);
            converterBinder.addBinding().to(BooleanStringConverter.class);
        }
    });
    ConverterRegistryImpl registry = injector.getInstance(ConverterRegistryImpl.class);