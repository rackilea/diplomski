public static class Person
{
    private Integer income;
    private Long    zipCode;  // not the county, as the person file does not contain it
    private String  firstname, lastname;

    private Integer aboveAverage;
}

public static class RawCounty
{
    private Long   zipCode;
    private String county;
    private String state;
}

public static class County
{
    private Set<Long> zipCodes;
    private String    county;
    private String    state;

    private Double    average;
}