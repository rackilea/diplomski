import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.io.WKBReader;

import java.util.Arrays;
import java.util.List;

public class Foo {
    public static void main(String... args) throws Exception {
        final List<String> points = Arrays.asList(
                "0101000020E6100000AECB9307F9D812400F2ADCE003704940",
                "0101000020E6100000E40AAE6CD6DA1240941F95531C704940",
                "0101000020E6100000C0D7C68E7CD81240F550364044704940"
        );
        final GeometryFactory gm = new GeometryFactory(new PrecisionModel(), 4326);
        final WKBReader wkbr = new WKBReader(gm);
        for (String point: points) {
            byte[] wkbBytes = wkbr.hexToBytes(point);
            final Geometry geom = wkbr.read(wkbBytes);
            System.out.printf("%s -> %s\n", point, geom.toText());
            // you can access longitude and latitude via
            double longitude = geom.getCoordinate().x;
            double latitude = geom.getCoordinate().y;
            // then do what you need to do with it
        }
    }
}