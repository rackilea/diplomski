public enum Animal {
  a1("CAT", 4), a2("DOG", 4);
  private String Name;
  private int E;

  private animal(String Name, int E)
  {
    this.Name = Name;
    this.E = E;
  }

  public String getName() {
    return Name;
  }

  public int getE() {
    return E;
  }
}