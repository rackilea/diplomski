import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of={"id"}) // this is the trick
public class Person {

    public Person() {}

    public Person(int id, String name) {
       this.id = id;
       this.name = name;
    }

    private int id;

    private String name;

}