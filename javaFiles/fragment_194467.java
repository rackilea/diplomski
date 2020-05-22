@XmlRootElement
public class MyListWrapper {

    @XmlElement(name = "List")
    private List<String> list;

    public MyListWrapper() {/*JAXB requires it */

    }

    public MyListWrapper(List<String> stringList) {
        list = stringList;
    }

    public List<String> getStringList() {
        return list;
    }

}