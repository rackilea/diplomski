public class Adapter extends XmlAdapter<C, String> {

    public String unmarshal(C pC) throws Exception {
        //some possible handling with the attribute over pC.getSomeAttribute();
        return pC.getC();
    }

    public C marshal(String pC) throws Exception {
       C c = new C();
       c.setC(pC)
       //some possible handling to set the attribute to c
       return c;
    }