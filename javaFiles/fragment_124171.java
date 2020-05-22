import javax.activation.MimetypesFileTypeMap;
import java.io.File;

class MimeForMedia {

    public static void main(String[] args) {
        String[] types = {
            "png", "jpg", "gif", "tif", "bmp",  // image
            "snd", "wav", "mp3", "ogg", "au",   // sound
            "mov", "avi", "mpg", "flv"  // video
            };
        MimetypesFileTypeMap typeMap = new MimetypesFileTypeMap();
        for (String type : types) {
            String name = "a." + type;
            String bestType = typeMap.getContentType(name);
            if (bestType.equals("application/octet-stream")) {
                System.out.print( "Using URLConnection:  " );
                try {
                    bestType = (new File(name)).toURI().toURL()
                        .openConnection().getContentType();
                } catch(Exception e) {
                    System.out.println( e.getMessage() );
                }
            }
            System.out.println (type + "  " + bestType);
        }
    }
}