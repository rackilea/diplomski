import static com.google.common.collect.Lists.newArrayList;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Application {

    private final Annotation qualifiers = new AnnotationLiteral<Any>() { };

    @Inject
    private List<RequiredModuleConfiguration> requiredModuleConfigurationInstance;

    @Inject
    private Instance<Module> moduleInstance;

    private final List<Module> modules = newArrayList();

    public void init() throws Exception {
        for (final RequiredModuleConfiguration requiredModuleConfiguration: 
                requiredModuleConfigurationInstance) {
            final String className = requiredModuleConfiguration.getClassName();
            final Class<Module> moduleClass = 
                (Class<Module>) Class.forName(className);

            final Instance<Module> currentModuleInstance = 
                moduleInstance.select(moduleClass, qualifiers);
            final Module module = currentModuleInstance.get();
            modules.add(module);
        }
        ...
    }

    ...
}