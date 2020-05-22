public class MainClass extends Activity {

     PictureCallback jpegCallback;

     public MainClass() {
         jpegCallback = new PictureCallback() {
              @Override void onPictureTaken(byte[], data, Camera camera) {
                  // some action performed
              }

         };
     }
}