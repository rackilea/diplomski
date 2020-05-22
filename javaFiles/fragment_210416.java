@JsonDeserialize(using=CitiesDeserializer.class)
public class Cities implements Iterable<City> {

    private final List<City> cities;

    public Cities(final List<City> cities) {
        this.cities = cities;
    }

    public Cities() {
        this.cities = new ArrayList<>();
    }

    public List<City> getCities() {
        return cities;
    }

    @Override
    public Iterator<City> iterator() {
        return cities.iterator();
    }
}