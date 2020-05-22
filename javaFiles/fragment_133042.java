@Entity
public class Project {

   @OneToMany(mappedBy = "project")
   private Collection<Task> tasks;

}

@Entity
public class Task {

   @ManyToOne
   private Project project;

}