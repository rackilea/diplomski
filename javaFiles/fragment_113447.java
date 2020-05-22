import java.util.ArrayList;
import java.util.List;

import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name = "ul", strict = false)
public class ULTag {

   @ElementList(name = "li", inline = true, required = false)
   List<LITag> liTags = new ArrayList<LITag>();

   public List<LITag> getLiTags() {
      return liTags;
   }

   public void setLiTags(List<LITag> liTags) {
      this.liTags = liTags;
   }

   public ULTag() {
   }

}