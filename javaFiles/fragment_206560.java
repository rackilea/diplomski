package image;

import java.io.InputStream;

public class ImageLoader {
    public static void main(String[] args ){
        String cmd = null;
        InputStream is = null;
        final String image = "save.png";

        if("test1".equals(args[0])){
            cmd = "ImageLoader.class.getClassLoader().getResourceAsStream(\""+image+"\")";
            is = ImageLoader.class.getClassLoader().getResourceAsStream(image);     //YES, FOUND


        }else if("test2".equals(args[0])){
            cmd = "ImageLoader.class.getResourceAsStream(\""+image+"\")";
            is = ImageLoader.class.getResourceAsStream(image);                      //NOT FOUND

        }else if("test3".equals(args[0])){
            cmd = "ImageLoader.class.getResourceAsStream(\"/"+image+"\")";
            is = ImageLoader.class.getResourceAsStream("/"+image);                  //YES, FOUND

        }else if("test4".equals(args[0])){
            cmd = "ImageLoader.class.getClassLoader().getResourceAsStream(\"/"+image+"\")";
            is = ImageLoader.class.getClassLoader().getResourceAsStream("/"+image); //NOT FOUND

        }else {
            cmd = " ? ";
        }

        System.out.println("With "+cmd+", stream loaded: "+(is != null));
    }
}