import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

public class Person {

   @Getter @Setter private String name;
   @Getter @Setter private int age = 10;
 }