@XmlRootElement
public class BaseFiltersType {

    private List<BaseFilterType> filter;

    @XmlPath("filter[@included='true']")
    public List<BaseFilterType> getFilter() {
        return filter;
    }

    public void setFilter(List<BaseFilterType> baseFilterType) {
        this.filter = baseFilterType;
    }

}