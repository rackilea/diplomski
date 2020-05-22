public class Installation {
  private Component type;
  private List<Installation> content;

  public Installation(Component type){
    this.type = type;
    this.content = new ArrayList<Component>();
  }

  //you can have methods for add, remove, etc...
}