import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "li", strict = false)
public class LITag {

   @Element(name = "strong", required = false)
   private String strong;

   public LITag() {
   }

   public String getStrong() {
      return strong;
   }

   public void setStrong(String strong) {
      this.strong = strong;
   }

}