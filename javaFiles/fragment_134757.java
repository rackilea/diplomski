public class OrganisationUnit {
    private Integer id;
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}

public class Results {

    private List<OrganisationUnit> results = new ArrayList<>();

    public List<OrganisationUnit> getResults() {
        return results;
    }

    public void setResults(List<OrganisationUnit> results) {
        this.results = results;
    }
}