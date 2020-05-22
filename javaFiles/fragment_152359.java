package leader;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;



@Entity
@NamedQuery(name="ProjectLeader.findAll", query="SELECT p FROM ProjectLeader p")
 public class ProjectLeader implements Serializable {
 private static final long serialVersionUID = 1L;

@Id
private int id;

//bi-directional many-to-one association to Project
@OneToMany(mappedBy="projectLeader",fetch=FetchType.EAGER,orphanRemoval=true)
private List<Project> projects;

public ProjectLeader() {
}

public int getId() {
    return this.id;
}

public void setId(int id) {
    this.id = id;
}

public List<Project> getProjects() {
    return this.projects;
}

public void setProjects(List<Project> projects) {
    this.projects = projects;
}

public Project addProject(Project project) {
    getProjects().add(project);
    project.setProjectLeader(this);

    return project;
}

public Project removeProject(Project project) {
    getProjects().remove(project);
    project.setProjectLeader(null);

    return project;
}

}