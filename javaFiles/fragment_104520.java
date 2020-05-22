import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class DefaultEmailManager  {

    public static final String JNDI_NAME = "java:jboss/mail/Default";

}