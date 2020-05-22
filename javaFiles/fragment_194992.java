@Entity
public class Line {

    @Embedded 
    @AttributeOverrides( {
        @AttributeOverride(name="x", column = @Column(name="startPointX") ),
        @AttributeOverride(name="y", column = @Column(name="startPointY") )
    } )
    private Point startPoint;

    @Embedded 
    @AttributeOverrides( {
        @AttributeOverride(name="x", column = @Column(name="endPointX") ),
        @AttributeOverride(name="y", column = @Column(name="endPointY") )
    } )
    private Point endPoint;
}

@Embeddable
public class Point
{
    private double x;
    private double y;
}