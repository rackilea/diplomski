import com.ximpleware.*;
import java.io.*;

public class removeAttrNode {
    public static void main(String[] s) throws VTDException, Exception{
        VTDGen vg = new VTDGen(); ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><Payment xmlns=\"http://api.com/schema/store/1.0\"><Store>abc</Store></Payment>";
        vg.setDoc(xml.getBytes());
        vg.parse(false); // turn off namespace awareness so that 
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        XMLModifier xm = new XMLModifier(vn);
        ap.selectXPath("//@xmlns");
        int i=0;
        while((i=ap.evalXPath())!=-1){
            xm.remove();
        }
        xm.output(baos);
        System.out.println(baos.toString());    
    }
}