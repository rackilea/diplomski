public class Global extends GlobalSettings {

// inject Jasypt StandardPBEStringEncryptor

@Override
public Configuration onLoadConfig(Configuration configuration, File file, ClassLoader classLoader) {
    final Config config = ConfigFactory.parseString(String.format("db.default.user=%s", callJasyptStringEncryptor()));

    return new Configuration(config.withFallback(configuration.getWrappedConfiguration().underlying()));
}}