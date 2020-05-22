import javax.xml.bind.annotation.*;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlRootElement
@XmlType(propOrder={"kitchen", "basement", "room", "innerPart", "upperPart"})
public class Foo {

   @XmlPath("house/kitchen/text()")
   public ... getKitchen(){}

   @XmlPath("house/room/text()")
   public ... getRoom(){}

   public ... getInnerPart(){}

   public ... getUpperPart(){}

   @XmlPath("house/basement/text()")
   public ... getBasement(){}

   ...
   ...
}