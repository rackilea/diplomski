@Root(name = "images") 
public class Images {

     @ElementList(entry = "image", required=false, inline = true)
     private List<String> imageList;

     public List<String> getImageList() {
         return imageList;
     }
}