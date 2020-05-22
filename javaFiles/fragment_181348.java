public interface Place {
    // Place can be an abstract class if you want. 
    // Making it abstract could cause some problems because it might make you use generics
    // I recommend an interface
    List<? extends Place> getSublocations();
    Place getParent();
}
public class World implements Place {

    private List<Country> countries;

    @Override
    public List<Country> getSublocations() {
        return this.countries;
    }

    @Override
    public Place getParent() {
        return null;
    }
}
public class Country implements Place {
    private List<City> cities;
    private World parent;

    @Override
    public List<City> getSublocations() {
        return this.cities;
    }

    @Override
    public World getParent() {
        return this.parent;
    }
}
public class City implements Place {
    private Country parent;

    @Override
    public List<? extends Place> getSublocations() {
        return null;
    }

    @Override
    public Country getParent() {
        return this.parent;
    }
}