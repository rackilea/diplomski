public Country(int id, String name, long population, double medianAge) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.medianAge = medianAge;
        this.languages = new ArrayList<>();
    }