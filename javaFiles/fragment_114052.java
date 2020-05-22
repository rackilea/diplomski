import java.util.List;
import org.xmlbeam.XBProjector;
import org.xmlbeam.annotation.XBRead;
public class ReadWayPoints {

    public interface WayPoint {
        @XBRead("./lat using #,#")
        double getLat();
        @XBRead("./lon using #,#")
        double getLon();
        @XBRead("./name")
        String getName();
        @XBRead("./course") 
        String getCourse();
        @XBRead("./distance using #,#")
        double getDistance();
    }
    public static void main(String[] args) {
        List<WayPoint> waypoints = new XBProjector().io().url("res://data.xml").evalXPath("/data/track/*").asListOf(WayPoint.class);
        for (WayPoint wp:waypoints) {
            System.out.println(wp.getName()+" "+wp.getLat()+":"+wp.getLon());                
        }
    }
}