package leader;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Project database table.
* 
*/
@Entity
@NamedQuery(name="Project.findAll", query="SELECT p FROM Project p")
public class Project implements Serializable {
private static final long serialVersionUID = 1L;

@Id
private int id;

//bi-directional many-to-one association to ProjectLeader
@ManyToOne
@JoinColumn(name="Leader_Id")
private ProjectLeader projectLeader;

public Project() {
}

public int getId() {
    return this.id;
}

public void setId(int id) {
    this.id = id;
}

public ProjectLeader getProjectLeader() {
    return this.projectLeader;
}

public void setProjectLeader(ProjectLeader projectLeader) {
    this.projectLeader = projectLeader;
}

}