@XmlRootElement
public class MyResponse {
    ...
    protected List<MyEntry> myEntries;
    ...
    @XmlJavaTypeAdapter(MyEntryAdapter.class)
    public List<MyEntry> getMyEntries() {
        return myEntries;
    }
    ...
}