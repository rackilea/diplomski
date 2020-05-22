import java.util.HashMap;
import scala.Predef;
import scala.Tuple2;
import scala.collection.JavaConverters;
import scala.collection.immutable.Map;

public class ToScalaTest {
  public static <A, B> Map<A, B> toScalaMap(HashMap<A, B> m) {
    return JavaConverters.mapAsScalaMapConverter(m).asScala().toMap(
      Predef.<Tuple2<A, B>>conforms()
    );
  }

  public static HashMap<String, String> test() {
    HashMap<String, String> m = new HashMap<String, String>();
    m.put("a", "Stackoverflow");
    return m;
  }
}