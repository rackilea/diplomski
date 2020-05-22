@Getter @Setter
public class Response {

    // json object named 'data' is an array holding -say- many Data objects 
    // (better name might be 'datas' or so since it has many objects, plural)
    @Getter @Setter
    private Data[] data;

    // Data contains name and and an array of Double arrays
    @Getter @Setter
    public static class Data {
        private String name;
        private Double[][] timeSeries;      
    }   

}