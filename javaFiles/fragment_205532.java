import lombok.Builder;
import lombok.ToString;

@Builder(builderMethodName = "hiddenBuilder")
@ToString
public class Person {

    private String name;
    private String surname;

    public static PersonBuilder builder(String name) {
        return hiddenBuilder().name(name);
    }
}