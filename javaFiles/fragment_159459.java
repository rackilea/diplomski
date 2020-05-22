@XmlRootElement(name = "FamilyFields") public class FamilyFields {

  @XmlElement public String relation;
  @XmlElement public String firstName;
  @XmlElement public String lastName;

  public FamilyFields() {}
}

@XmlRootElement(name = "NewFields") public class NewFields {

  @XmlElement public String empFirstName;
  @XmlElement public String empLastName;
  @XmlElementWrapper(name = "family")
  @XmlElement(name = "FamilyFields")
  public List<FamilyFields> familyFields;

  public NewFields() {}
}