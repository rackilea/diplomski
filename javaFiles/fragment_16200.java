@ManagedBean
@ViewScoped
public class Bean {

    private List<String> checkedValues;
    private List<String> availableValues;

    @PostConstruct
    public void init() {
        availableValues = new ArrayList<String>();
        availableValues.add("1");
        availableValues.add("2");
        availableValues.add("3");
        // ...
    }

    public void submit() {
        System.out.println("Checked values: " + checkedValues);
    }

    public List<String> getCheckedValues() {
        return checkedValues;
    }

    public void setCheckedValues(List<String> checkedValues) {
        this.checkedValues = checkedValues;
    }

    public List<String> getAvailableValues() {
        return availableValues;
    }

}