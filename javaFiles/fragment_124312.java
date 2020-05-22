@XmlRootElement(name="fooRoot")
class MyFoo {

  @XmlPath("bar/lol/text()")
  String lol;

  @XmlElement("noob/boon/thisIsIt/text()")
  String thisIsIt;

  @XmlTransient
  Object somethingUnrelated;
}