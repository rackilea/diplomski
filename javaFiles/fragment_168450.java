public class Parent {
  private final String companyName;

  public Parent(String name) {
    this.companyName = name;      // ignoring error-checking here
  }

  public String getCompanyName() {
    return companyName;
  }
}

public class Subsidiary extends Parent {
  private final String subsidiaryName;

  public Subsidiary(String parentName, String subsidiaryName) {
    super(parentName);
    this.subsidiaryName = subsidiaryName;
  }

  public String getSubsidiaryName() {
    return subsidiaryName;
  }
}