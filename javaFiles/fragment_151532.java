@Entity
public class MultiPolygon {

    @Id
    private int id;

    @Column(columnDefinition = "geometry(MultiPolygon,4326)")
    private com.vividsolutions.jts.geom.MultiPolygon polygon;

    // ... Getters - setters 
}