public class Project {

  public Project() {

   Developer developer = new Developer();
   developer.developerMethod(this);
  }
}

public class Developer {

public void developerMethod(Project project) {
 // do something
}
}