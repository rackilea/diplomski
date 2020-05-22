import com.ximpleware.*;
public class concatTest{
    public static void main(String s1[]) throws Exception {
        VTDGen vg= new VTDGen();
        String s = "<users><user><firstName>some </firstName><lastName> one</lastName></user></users>";
        vg.setDoc(s.getBytes());
        vg.parse(false);
        VTDNav vn = vg.getNav();
        AutoPilot ap = new AutoPilot();
        ap.selectXPath("concat('good', ' luck')");
        System.out.println(" concat output ==>"+ap.evalXPathToString());
        ap.selectXPath("concat(/, '')");
        ap.bind(vn);
        System.out.println(" concat output ==>"+ap.evalXPathToString());
    }

}