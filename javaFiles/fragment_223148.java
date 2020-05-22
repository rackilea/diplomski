@XmlRootElement( name = "entity")
public class Entity {

    private int age = 22;
    private String firstname = "Michael";

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        this.age = age;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname( String firstname ) {
        this.firstname = firstname;
    }
}

public class Main {
    public static void main( String[] args ) {
        JAXBContext jc = JAXBContext.newInstance( Entity.class );
        Marshaller m = jc.createMarshaller();
        m.marshal( new Entity(), System.out );
    } 
}