import static com.google.common.collect.Lists.newArrayList;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Singleton;

@Singleton
public class RequiredModuleConfigurationLoader {

    private final List<RequiredModuleConfiguration> configurationList = 
        newArrayList();

    public RequiredModuleConfigurationLoader() {
        // read the XML file here
        configurationList.add(new RequiredModuleConfiguration(
            "cdiproto.ModuleOne", "moduleConfig1"));
        configurationList.add(new RequiredModuleConfiguration(
            "cdiproto.ModuleTwo", "moduleConfig2"));
    }

    @Produces
    public List<RequiredModuleConfiguration> getRequiredModuleConfigurations() {
        return newArrayList(configurationList);
    }

    @Produces
    public ModuleConfiguration getModuleConfiguration(
            final InjectionPoint injectionPoint) {
        final String injectedClassName = injectionPoint.getMember()
            .getDeclaringClass().getName();
        for (final RequiredModuleConfiguration requiredModuleConfiguration: 
                configurationList) {
            final String moduleClassName = 
                requiredModuleConfiguration.getClassName();
            if (moduleClassName.equals(injectedClassName)) {
                final String option = 
                    requiredModuleConfiguration.getSubConfiguration();
                return new ModuleConfiguration(option);
            }
        }
        throw new IllegalStateException("Unknown module: " + 
            injectedClassName);
    }
}