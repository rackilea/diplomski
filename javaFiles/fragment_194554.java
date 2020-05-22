enum ModulesEnum {

  FIRST(new C1()), SECOND(new C2()); // and so on

  private ModulesEnum(Intr intr) { this.obj = intr; }
  private Intr obj;

  public Intr getObj() { return obj; }

}