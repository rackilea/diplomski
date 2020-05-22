public class Main {
    public static void main(String args[]) {
        State S = new State("Florida", new District("Miami-Dade", 2752000),
                new City("Miami", 463347),
                new City("Tampa", 385430),
                new District("Broward", 1936000));
        System.out.println("The Population is: " + S.getPopulation());
    }
}

class CitiesAndDistricts {
    int population;
}

class City extends CitiesAndDistricts{
    String name;


    public City(String name, int population) {
        this.name = name;
        this.population = population;
    }
}

class District extends CitiesAndDistricts{
    String name;

    public District(String name, int population) {
        this.name = name;
        this.population = population;
    }
}

class State {
    String name;
    int population;
    CitiesAndDistricts[] CAndD;

    public State(String name, CitiesAndDistricts ... entities) {
        this.name = name;
        CAndD = entities;
        for(int i = 0; i < CAndD.length; i++) {
            this.population += CAndD[i].population;
        }
    }

    public int getPopulation() {
        return population;
    }
}