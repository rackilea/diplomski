class MyComponent {

  @Inject MyCollaborator collaborator;

  public void myBusinessMethod() {
    collaborator.doSomething(); // -> NullPointerException   
  } 
}