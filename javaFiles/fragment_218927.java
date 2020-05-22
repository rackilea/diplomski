class Author(val firstName: String,
    val lastName: String) extends Comparable[Author] {
  override def compareTo(that: Author) = {
    val lastNameComp = this.lastName compareTo that.lastName
    if (lastNameComp != 0) lastNameComp
    else this.firstName compareTo that.firstName
  }
}
object Author {
  def loadAuthorsFromFile(file: java.io.File): List[Author] = ???
}