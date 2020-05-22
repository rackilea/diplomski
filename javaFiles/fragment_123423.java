public enum Region {
    CALIFORNIA("http://http://california.gov/", 10123321),
    HAWAII("http://hawaii.gov", 5123321),
    LOUISIANA("http://louisiana.gov/", 8123321);
    public final String url;
    public final int population;
    private Region(String url, int population) {
        this.url = url;
        this.population;
    }
}

…

System.out.println(Region.CALIFORNIA.url);