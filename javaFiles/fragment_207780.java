private Map<String, Technology> techs = new HashMap<>();
....
public void addProject(String tech, String version, String projectName){
    Technology t = techs.get(tech);
    if(t == null){ //doesn't exist
         t = new Technology(tech);
         techs.put(tech, t);
    }
    t.addProjectToVersion(version, new Project(projectName));
}

public void insertData(){
    addProject("java", "1.7", "project1");
    addProject("java", "1.7", "project2");
    addProject("java", "1.8", "project1");
    addProject("junit", "4.12", "project1");

    System.out.println(techs);
}