import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.ArrayList;

@Configuration
public class CxfConfiguration 
{
    @Autowired
    private ApplicationContext applicationContext;

    @Bean( destroyMethod = "shutdown" )
    public SpringBus cxf() {
        return new SpringBus();
    }

    @Bean(name = "RestWS") 
    public Server getServerRest()
    {
        JAXRSServerFactoryBean restFactory = new JAXRSServerFactoryBean();
        ArrayList<Object> objectArrayList = new ArrayList<>();
        restFactory.setServiceBean(getBaseService());
        restFactory.setProvider(new JacksonJsonProvider());

        return restFactory.create();
    }
   @Bean 
    public Server getServer() 
    {
        Bus bus = (Bus) applicationContext.getBean(Bus.DEFAULT_BUS_ID);
        Object implementor = getBaseService();
        EndpointImpl endpoint = new EndpointImpl(bus, implementor);
        endpoint.publish("/Base");
        return endpoint ;
    }

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("facade.xml");

    @Bean
    public BaseService getBaseService()
    {
        return (BaseService)applicationContext.getBean("base_service");
    }
}