@XmlRootElement(name = "Proj")
@XmlType
@XmlEnum(String.class)
public enum ProjectType {
  @XmlEnumValue("II")      // or @XmlEnumValue(2)
  TestTwo(2),
  @XmlEnumValue("III")      // or @XmlEnumValue(3)
  TestThree(3);
  // ....
}