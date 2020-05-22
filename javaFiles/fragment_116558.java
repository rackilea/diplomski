@XmlRootElement
class A
{
  @XmlTransient
  Map<String, String> map;

  //For JAXB use
  private void setBeans(List<Bean> beans)
  {
    //Populate map
  }

  //For JAXB use
  @XmlElement(name = "bean")
  private List<Bean> getBeans()
  {
    //Convert map to List<Bean>
  }
}