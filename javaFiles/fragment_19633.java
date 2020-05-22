import scala.collection.JavaConverters;
import scala.collection.immutable.Stream;

...

List<String> list = new ArrayList<String>();

\\ Fill the list somehow...

Iterator<String> it = list.iterator();

Stream<String> stream = JavaConverters.asScalaIteratorConverter(it)
                                      .asScala().toStream();