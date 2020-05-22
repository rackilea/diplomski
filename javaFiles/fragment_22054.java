@XmlRootElement(name = "publisher")
class Person
{
 @XmlElement(required = true)
 int id;
 @XmlElement(required = true)
 @XmlJavaTypeAdapter(NameAdapter.class)
 String name;
}