@ManagedBean
public class RuleTreeBeanAddActionNode {
    private List<Entry> entries;

    @PostConstruct
    public void init() {
        entries = new ArrayList<Entry>();
        entries.add(new Entry("foo", "bar"));
    }

    public List<Entry> getEntries() { return entries; }
}