@XmlElement
public String getName() {
     return person.getName();
}

public void setName(String name) {
    if (person == null){
       person = new Person();
    }
    person.setName(name);
}