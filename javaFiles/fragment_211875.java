public class FooConfigurationService {
    ...
    public void save(File location, FooConfiguration configuration) { ... }    
    public <T extends FooConfiguration> T load(File location, Class<? extends T> clazz) { ... }
}

...

FooConfigurationFactory factory = ...;
this.config = factory.load(location, FooConfigurationImpl);