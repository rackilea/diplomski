public class Restaurant implements Comparable<Restaurant> {

    @Id @GeneratedValue private Long id;
    private String name;
    @Convert(PointConverter.class) private Point location; //Encapsulates lat/lon 
    private int zip;
    private double score;
    private String description;
    private boolean halal;