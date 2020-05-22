import org.springframework.security.config.BeanIds;
import org.springframework.security.ldap.server.ApacheDSContainer;
...
public void onFileChange(File file) {
    ApplicationContext ctx = ContextLoader.getCurrentWebApplicationContext();  
    if (ctx == null)
        return; 
    ApacheDSContainer container = (ApacheDSContainer)ctx.getBean(BeanIds.EMBEDDED_APACHE_DS); 

    if (container != null) {
        try {
            container.destroy();
            container.afterPropertiesSet();
        }
        catch(Exception exec) {
            // handle error
        }
    }
}