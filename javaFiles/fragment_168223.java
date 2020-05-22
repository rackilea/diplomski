class Thumbnail extends Component {
   ...
   BufferedImage cachedThumbnail;

   public Thumbnail(File thumbnailFile) {
       //read image
       //(scale image)
       this.cachedThumbnail = ...;
   }
   ...
   public static void paint(Graphics2D g) {
     //only paint the cached image ...
     g.drawImage(cachedThumbnail,..,..,..,..);
   }
}