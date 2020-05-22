import com.ximpleware.extended.*;
public class mem_mapped_read {
    public static void main(String[] s) throws Exception{
        VTDGenHuge vg = new VTDGenHuge();
        if (vg.parseFile("test.xml",true,VTDGenHuge.MEM_MAPPED)){
            VTDNavHuge vnh = vg.getNav();
        AutoPilotHuge aph = new AutoPilotHuge(vnh);
        aph.selectXPath("//*");
        int i = 0;
        while ((i=aph.evalXPath())!=-1){
            System.out.println(" element name is "+vnh.toString(i));
        }

        }
    }
}