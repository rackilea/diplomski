import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration
public class BeanTest {

    @Autowired
    ErrorAttributes errorAttributes;

    @Test
    public void testMyBean() {
        RequestAttributes requestAttributes = new RequestAttributes();
        System.out.println(errorAttributes.getErrorAttributes(requestAttributes, true));
    }

    @Configuration
    @ComponentScan(basePackages = "package.where.your.configuration.is")
    public static class SpringTestConfig {

    }
}