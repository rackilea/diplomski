public class Foo {
  private String title;
  private String subject;
  private boolean isDirty=true;


  public void onPersist(){
    this.isDirty=false;
  }

  public String setTitle(String title){
    this.isDirty=true;
    this.title=title;
  }

  //more setters und getters

}