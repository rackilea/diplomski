public interface Populated {

    int getPopulation();

}

public class Country implements Populated {

    @Override
    public int getPopulation() {
        ...
    }

}

// same for Continent and City