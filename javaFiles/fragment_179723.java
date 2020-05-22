public class Restaurant implements Comparable<Restaurant>{

    private String name;
    private String lng;
    private String lat;
    private String address;
    private String rate;
    private String comment;

    ...
    constructor/getters/setters
    ...

    @Override
    public int compareTo(Restaurant rest) {
        //TODO: check if rate is null if this can happen in your code
        return rate.compareTo(rest.rate); //comparing on rate attribute
    }

}