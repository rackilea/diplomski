import com.google.common.base.Joiner
import scala.collection.JavaConverters._

object MainJ extends App {
  val fantasyGeneres = Array("Space Opera", "Horror", "Magic realism", "Religion")
  val joined = Joiner.on(',').join(fantasyGeneres.toIterable.asJava)
  println(joined)
}