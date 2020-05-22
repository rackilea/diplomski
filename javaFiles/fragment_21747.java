// This helps you use Java collections like Scala ones
import collection.JavaConversions._

case class Monster(name: String, hp: Int) {}
val horde = new java.util.concurrent.ConcurrentSkipListMap[Int,Monster]

horde put (0, Monster("wolf",7))
horde put (1, Monster("orc",3))

for (h <- horde) println(h)   // Prints out both

Iterator.iterate(Option(horde.firstEntry)) {
  case None => None
  case Some(e) =>
    val m = e.getValue
    if (m.name=="wolf") horde.remove(1)     // Kill the orc
    else if (m.name=="orc") horde.remove(0) // Kill the wolf
    Option(horde.higherEntry(e.getKey))
}.takeWhile(_.isDefined).foreach(_=>())

for (h <- horde) println(h)   // Prints out just the wolf