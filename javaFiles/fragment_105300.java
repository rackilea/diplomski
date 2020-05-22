import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class Utils {
  public static BeanManager getBeanManager() {
    try {
        InitialContext initialContext = new InitialContext();
        return (BeanManager) initialContext.lookup("java:comp/BeanManager");
    } catch (NamingException e) {
        throw new RuntimeException("Failed to retrieve BeanManager!", e);
    }
  }

  public static <T> T getBean(Class<T> c) {
    T result = null;
    BeanManager bm = getBeanManager();
    Set<Bean<?>> beans = bm.getBeans(c);
    if (! beans.isEmpty()) {
        Bean<?> bean = beans.iterator().next();
        result = c.cast(bm.getReference(bean, c, bm.createCreationalContext(bean)));
    }
    return result;
  }
}