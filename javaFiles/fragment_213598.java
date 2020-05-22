import com.ximpleware.*;
import java.io.*;
public class updateXSD {
    public static void main(String[] s) throws VTDException, IOException{
        VTDGen vg = new VTDGen();
        if (!vg.parseFile("d:\\xml\\xsd.xml", true)){
            return;
        }
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot(vn);
        ap.declareXPathNameSpace("xs", "XSD namespace here");
        ap.selectXPath("//xs:element[@name='Bike']/@type");
        XMLModifier xm = new XMLModifier(vn);
        int i=-1;
        while((i=ap.evalXPath())!=-1){
            xm.updateToken(i+1, "Twowheeler");
        }
        xm.output("d:\\xml\\newXSD.xml");
    }
}