import com.ximpleware.*;
import java.io.*;

public class removeAttrNode {
    public static void main(String[] s) throws VTDException, Exception{
        VTDGen vg = new VTDGen(); ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String xml = "<Payment attr1=' some val' attr2='some other val'><Store><![CDATA[abc]]></Store></Payment>";
        vg.setDoc(xml.getBytes());
        vg.parse(false); // turn off namespace awareness so that 
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        XMLModifier xm = new XMLModifier(vn);
        ap.selectXPath("/Payment/@*");// select all attr node of Payment element
        int i=0;
        while((i=ap.evalXPath())!=-1){
            System.out.println("attr name "+vn.toString(i)+ " attr val ==>"+ vn.toString(i+1));
            xm.removeAttribute(i);
        }
        xm.output(baos);
        System.out.println(baos.toString());    
    }
}