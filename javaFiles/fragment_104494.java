import org.apache.tools.ant.DynamicElement;
import org.apache.tools.ant.Task;

public final class AntTask extends Task implements DynamicElement {

   private ...

   public void setLayout( String layout ) {
   }

   public void setGui( boolean gui ) {
   }

   @Override
   public Object createDynamicElement( String name ) {
      if( name.equals( "log-server" )) {
         return new Logserver();
      }
      return null;
   }

   ...

   @Override
   public void execute() {
   }
}