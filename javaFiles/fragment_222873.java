@XmlAccessorType(XmlAccessType.FIELD)
public class Test0 {
    String e1;

    public static void main(String[] args) throws Exception {
        String xml = "<root><e1><![CDATA[Need Help]]></e1></root>";
        Test0 t = JAXB.unmarshal(new StringReader(xml), Test0.class);
        System.out.println(t.e1);
    }
}