final class City {

    @SerializedName("_id")
    final int id;

    @SerializedName("country")
    final String country;

    @SerializedName("name")
    final String name;

    @SerializedName("coord")
    final Coordinates coordinates;

    private City(final int id, final String country, final String name, final Coordinates coordinates) {
        this.id = id;
        this.country = country;
        this.name = name;
        this.coordinates = coordinates;
    }

    static City of(final int id, final String country, final String name, final Coordinates coordinates) {
        return new City(id, country, name, coordinates);
    }

    @Override
    public boolean equals(final Object o) {
        if ( this == o ) {
            return true;
        }
        if ( o == null || getClass() != o.getClass() ) {
            return false;
        }
        final City that = (City) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @SuppressWarnings("ConstantConditions")
    public static int compareByName(final City city1, final City city2) {
        return city1.name.compareTo(city2.name);
    }

}