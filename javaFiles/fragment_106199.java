import scala.collection.mutable

class CaseInsensitiveStrings {

  private[this] val strings = new mutable.HashSet[String]()

  def addString(elem: String) = strings.add(elem.toUpperCase)

  def contains(elem: String) = strings.contains(elem.toUpperCase)

}