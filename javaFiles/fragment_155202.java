@XmlElement
public void setName(String name) {
    if (person == null){
       person = new Person();
    }
    person.setName(name);
}