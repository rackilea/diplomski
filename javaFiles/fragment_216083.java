package spring;

import org.springframework.security.ldap.server.ApacheDSContainer;

public final class EmbeddedApacheDsConfigurer implements BeanPostProcessor {

    private String workingDirectory;

    public void setWorkingDirectory(String workingDirectory) {
        this.workingDirectory = workingDirectory;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApacheDSContainer) {
             ((ApacheDSContainer)bean).setWorkingDirectory(new File(workingDirectory));
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
         return bean;
    }
}