import org.codehaus.groovy.runtime.HandleMetaClass ;
import org.codehaus.groovy.runtime.InvokerHelper ;

public class Decorator {
  public static void decorate( Object o, String name, Object value ) {
    HandleMetaClass hmc = new HandleMetaClass( InvokerHelper.getMetaClass( o ), o ) ;
    hmc.setProperty( name, value ) ;
  }
}