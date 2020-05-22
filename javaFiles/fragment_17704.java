class Pet {
  protected String name;
  protected boolean indoor;
  public Pet(String a, boolean b){
      name = a;  // <-- assigns the argument to the instance variable
      indoor = b;
  }

  public String getName() { return name; }
  public boolean getIndoor() { return indoor; }
}