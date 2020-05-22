import java.util.Collection;

import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.io.ParseException;
import com.vividsolutions.jts.io.WKTReader;
import com.vividsolutions.jts.operation.linemerge.LineMerger;

public class LineJoin {

  public static void main(String[] args) throws ParseException {
    /*String[] WKTS = { "LINESTRING (254058.76074485347 475001.2186020431, 255351.04293761664 474966.9279243938)",
        "LINESTRING (255351.04293761664 474966.9279243938, 255529.29662365236 474272.4599921228)",
        "LINESTRING (255529.29662365236 474272.4599921228, 256166.05830998957 473979.44920198264)",
        "LINESTRING (256166.05830998957 473979.44920198264, 256082.8878282134 472762.2531920295)",
        "LINESTRING (256082.8878282134 472762.2531920295, 254245.37250651795 472802.681197444)",
        "LINESTRING (254245.37250651795 472802.681197444, 254294.87550167093 473782.10435392085)",
        "LINESTRING (255802.5570897992 475306.663459122, 256973.3861333156 473826.71649389854)",
        "LINESTRING (256973.3861333156 473826.71649389854, 256996.781511873 472271.0759416939)",
        "LINESTRING (254134.08645022905 471750.25133671844, 253091.20265363617 473772.75685744354)",
        "LINESTRING (252764.19811300343 475015.97340571403, 253526.90397945273 476194.3201198712)",
        "LINESTRING (253526.90397945273 476194.3201198712, 254983.29259833007 475930.5996061625)" };*/
    String[] WKTS = {"LINESTRING(10 40,11 41)","LINESTRING(11 41,12 42)"};
    WKTReader reader = new WKTReader();
    LineMerger merger = new LineMerger();
    for (String wkt : WKTS) {
      Geometry geom = reader.read(wkt);
      merger.add(geom);
    }

    Collection<LineString> collection = merger.getMergedLineStrings();

    for (LineString l : collection) {
      System.out.println(l);
    }
  }

}