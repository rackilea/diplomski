import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "strong", strict = false)
public class StrongTag {

   @Element(name = "strong", required = false)
   private String strong;

   public StrongTag() {
   }

   public String getStrong() {
      return strong;
   }

   public void setStrong(String strong) {
      this.strong = strong;
   }
}