@XmlRootElement(name = "repositories")
public class RepositoryListWrapper {
    private List<Repository> list;

    protected RepositoryListWrapper() {
    } // Keep JAXB happy

    public RepositoryListWrapper(List<Repository> list) {
        this.list = list;
    }

    @XmlElement(name = "repository")
    public List<Repository> getRepositories() {
        return list;
    }
}