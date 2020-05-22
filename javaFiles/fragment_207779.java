public class Technology{

    private String name;
    private Map<String, List<Project>> projects;

    public Technology(String name){
        this.name = name;
        this.projects = new HashMap<>();
    }

    public void addProjectToVersion(String version, Project project){
        List<Project> l = this.projects.get(version);
        if(l == null){ //doesn't exist
            l = new ArrayList<>();
            this.projects.put(version, l);
        }
        l.add(project);
    }
}