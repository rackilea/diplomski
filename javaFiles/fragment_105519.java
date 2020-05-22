@XmlRootElement
public class BoxItem {

    @XmlElementWrapper(name = "integerMap")
    Map<Integer, ListWrapper> intgerStringArrMap;

    BoxItem() {
        intgerStringArrMap = new HashMap<Integer, ListWrapper>();
        for (int i = 0; i < 2; i++) {
            ArrayList<String> stringArrayList = new ArrayList<String>();
            ListWrapper wrapper = new ListWrapper();

            wrapper.setList(stringArrayList);

            for (int j = 0; j < 2; j++) {
                stringArrayList.add("2");
            }
            intgerStringArrMap.put(i, wrapper);
        }
    }

    public static void main(String[] args) throws JAXBException {
        BoxItem box = new BoxItem();
        JAXBContext jc = JAXBContext.newInstance(BoxItem.class);
        jc.createMarshaller().marshal(box, System.out);

    }
}

class ListWrapper {

    @XmlElementWrapper(name = "wrapperList")
    private List<String> list;

    public void setList(List<String> list) {
        this.list = list;
    }
}