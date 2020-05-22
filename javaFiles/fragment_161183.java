@Entity
public class Line {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDb", unique = true, nullable = false)
    private int id;

    @ElementCollection
    @CollectionTable(name="points_table", joinColumns = @JoinColumn(name="idDb"))
    @IndexColumn(name = "idx")
    @Column(name="point_val")
    private List<Point2D.Double> points = new ArrayList<Point2D.Double>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Point2D.Double> getPoints() {
        return points;
    }

    public void setPoints(List<Point2D.Double> points) {
        this.points = points;
    }
}