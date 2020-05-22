public enum ExampleClass {
  INSTANCE("nothing"),
  ITEM;

  private String description;

  //Will be used to instantiate INSTANCE("nothing")
  private ExampleClass(String description) {
     this.description = description;
  }

  //Will be used to instantiate ITEM
  private ExampleClass() {
  }
}