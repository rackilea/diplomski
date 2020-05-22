public class Recurs {

    private List<Object> custom;

    @XmlAnyElement
    public List<Object> getCustom() {
        if (custom == null) {
            custom = new ArrayList<>();
        }
        return custom;
    }

    public void setCustom(List<Object> custom) {
        this.custom = custom;
    }
}


@XmlRootElement
@XmlSeeAlso({ Recurs.class }) // !!! This is important
public class Xml {
    private List<Object> custom;

    @XmlAnyElement
    public List<Object> getCustom() {
        if (custom == null) {
            custom = new ArrayList<>();

            JAXBElement<String> lv2elem;
            Recurs recurs = new Recurs();
            for (int i = 1; i <= 2; i++) {
                lv2elem = new JAXBElement<String>(new QName("lv2"), String.class, "val" + i);
                recurs.getCustom().add(lv2elem);
            }
            JAXBElement lv1elem = new JAXBElement(new QName("lv1"), Recurs.class, recurs);
            custom.add(lv1elem);
        }
        return custom;
    }

}