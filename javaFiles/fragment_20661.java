@JsonSerialize(using = PersonSerializer.class)
public class Person {
    private String type; 
    private String name; 
    private String surname; 
}