@JsonDeserialize(using = MyDeserializer.class)
public class RectangleDto {

    private int area;
    private String useless_parameter;
    // getters, setters...
}