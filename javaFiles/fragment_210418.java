@JsonDeserialize(using=CityDeserialzer.class)
public class City {

    private String name;

    private List<Office> offices;

    // Setters and getters
}