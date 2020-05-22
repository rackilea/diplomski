@Data
@JsonPropertyOrder({"fa1", "fb1", "fa2", "fb2"})
public class A {

    private String fA1;
    private String fA2;

    @Delegate
    @JsonIgnore
    private B b = new B();
}