@Override
public InstrumentationConfiguration createClassLoaderConfig() {
    InstrumentationConfiguration.Builder builder = InstrumentationConfiguration.newBuilder();
    builder.addInstrumentedClass(OriginalMessenger.class.getName());
    return builder.build();
}