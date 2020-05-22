class MovieData {

    private static List<String> NAME_PROPERTIES = Arrays.asList("movieName", "movieTitle");

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnySetter
    private void parseUnknownProperties(String propertyName, String propertyValue) {
        if (NAME_PROPERTIES.contains(propertyName) && !propertyValue.isEmpty()) {
            this.name = propertyValue;
        }
    }

    @Override
    public String toString() {
        return name;
    }
}