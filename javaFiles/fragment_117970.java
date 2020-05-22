import java.util.ArrayList;
import java.util.List;

public class Fields {
    private Issuetype issuetype;
    private Integer timespent;
    private Integer aggregatetimespent;
    private Object resolution;
    private Object customfield11201;
    private Project project;
    private List<Issuelink> issuelinks = new ArrayList<Issuelink>();
    public Issuetype getIssuetype() {
        return issuetype;
    }
    public void setIssuetype(Issuetype issuetype) {
        this.issuetype = issuetype;
    }
    public Integer getTimespent() {
        return timespent;
    }
    public void setTimespent(Integer timespent) {
        this.timespent = timespent;
    }
    public Integer getAggregatetimespent() {
        return aggregatetimespent;
    }
    public void setAggregatetimespent(Integer aggregatetimespent) {
        this.aggregatetimespent = aggregatetimespent;
    }
    public Object getResolution() {
        return resolution;
    }
    public void setResolution(Object resolution) {
        this.resolution = resolution;
    }
    public Object getCustomfield11201() {
        return customfield11201;
    }
    public void setCustomfield11201(Object customfield11201) {
        this.customfield11201 = customfield11201;
    }
    public Project getProject() {
        return project;
    }
    public void setProject(Project project) {
        this.project = project;
    }
    public List<Issuelink> getIssuelinks() {
        return issuelinks;
    }
    public void setIssuelinks(List<Issuelink> issuelinks) {
        this.issuelinks = issuelinks;
    }
    @Override
    public String toString() {
        return "Fields [issuetype=" + issuetype + ", timespent=" + timespent
                + ", aggregatetimespent=" + aggregatetimespent
                + ", resolution=" + resolution + ", customfield11201="
                + customfield11201 + ", project=" + project + ", issuelinks="
                + issuelinks + "]";
    }
}