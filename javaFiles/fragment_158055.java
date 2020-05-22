enum Country {

    INDIA("India", "IND"), RUSSIA("Russia", "RUS"), NORTH_AMERICA(
            "North America", "NA");

    private String name;
    private String code;

    Country(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getters and other methods for name and code
}