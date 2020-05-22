import scala.util.parsing.combinator._

object Parser extends RegexParsers {

  override val skipWhitespace = false

  val word = """[A-Za-z]+""".r
  val separator = """\s+""".r    
  val colon = """(\s+:\s+)?""".r // optional colon
  val ws = """[^\S\n]+""".r      // all whitespace except newline
  val age = "[0-9]+".r

  val name = (repsep(word, ws) <~ separator) ^^ (_.mkString(" "))
  val nameHeader = "Name" ~ separator
  val childNameHeader = ("Daughters" | "Sons") ~ separator ~ nameHeader

  val person = nameHeader ~> name ~ (childNameHeader ~> name) ~ age <~ colon ^^ (p => (p._1._1, p._1._2, p._2))
  val persons = rep(person)

}

object Main extends App {

  val input  =
    """Name
      |John Doe
      |Sons
      |Name
      |Son of John
      |28
      |:
      |Name
      |Jane Doe
      |Daughters
      |Name
      |Daughter of Jane
      |32""".stripMargin

  val result = Parser.parse(Parser.persons, input)
  // prints '[13.3] parsed: List((John Doe,Son of John,28), (Jane Doe,Daughter of Jane,32))'
  println(result)
}