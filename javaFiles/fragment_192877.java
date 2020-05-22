public enum CarModel {
    DIABLO("Lamborghini", "Italy"),
    P911("Porsche", "Germany");

    private String manufacturer;
    private String country;

    private CarModel(String manufacturer, String country) {
        this.manufacturer = manufacturer;
        this.country = country;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getCountry() {
        return country;
    }
}