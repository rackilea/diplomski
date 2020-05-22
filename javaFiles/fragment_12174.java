public class GeoBean {

    private String $reql_type$;
    private double coordinates[];
    private String type;


    public GeoBean() {}
    public GeoBean(double[] coordinates) {
        this.$reql_type$ = "GEOMETRY";
        this.coordinates = coordinates;
        this.type = "POINT";
    }

    public String get$reql_type$() {
        return $reql_type$;
    }

    public void set$reql_type$(String $reql_type$) {
        this.$reql_type$ = $reql_type$;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}