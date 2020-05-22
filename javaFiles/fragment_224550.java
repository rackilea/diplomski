import com.ximpleware.*;
import java.io.*;

public class simpleMerge {
    static VTDGen vg = new VTDGen();
    public static void main(String[] s) throws VTDException,IOException{
        FileOutputStream fos = new FileOutputStream("d:\\xml\\o.xml");
        // write header to 
        byte[] header=("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"+
        "<products>").getBytes();
        fos.write(header);
        appendSingleFile("d:\\xml\\xml-1.xml",fos);
        appendSingleFile("d:\\xml\\xml-2.xml",fos);
        fos.write("</products>".getBytes());

    }
    // write everything under root into output efficiently, ie. direct byte copying
    public static void appendSingleFile(String fileName,FileOutputStream fos) throws VTDException,IOException{
        if (!vg.parseFile(fileName, false)){
            System.out.println("invalid file:"+fileName);
            System.exit(1);
        }
        VTDNav vn = vg.getNav();
        long l = vn.getContentFragment();
        fos.write(vn.getXML().getBytes(),(int)l,(int)(l>>32));
        vg.clear();
    }
}