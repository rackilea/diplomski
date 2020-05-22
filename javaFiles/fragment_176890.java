import scala.collection.JavaConverters$;
import scala.collection.immutable.Map;

public class Whatever {
  public <K, V> Map<K, V> convert(java.util.Map<K, V> m) {
    return JavaConverters$.MODULE$.mapAsScalaMapConverter(m).asScala().toMap(
      scala.Predef$.MODULE$.<scala.Tuple2<K, V>>conforms()
    );
  }
}