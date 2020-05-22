import com.bbn.openmap.LatLonPoint;
import com.bbn.openmap.proj.coords.DMSLatLonPoint;

public class TestProgram {

   /**
    * @param args
    */
   public static void main(String[] args) {

           // 45:20:00.0N/24:00:00.0E
           LatLonPoint BASE_LOC = new DMSLatLonPoint(false, 45, 20, 00.0f, false, 24, 00, 00.0f).getLatLonPoint();
           System.out.println("BASE_LOC: " + BASE_LOC);

           LatLonPoint OBJECT_LOC = new LatLonPoint(52.749355, 26.0);
           System.out.println("OBJECT_LOC: " + OBJECT_LOC);

           float distance = BASE_LOC.distance(OBJECT_LOC);
           float az = BASE_LOC.azimuth(OBJECT_LOC);

           LatLonPoint CONVERTED_POINT = BASE_LOC.getPoint(distance, az);

           System.out.println("CONVERTED_POINT " + CONVERTED_POINT);

   }