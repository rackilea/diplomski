public class ImageDataCollection {

       @SerializedName("data")
       private List<ImageData> imageDataList;

       public List<ImageData> getImageDataList() {
          return imageDataList;
       }

       public void setImageDataList(List<ImageData> imageDataList) {
          this.imageDataList = imageDataList;
       }  
    }