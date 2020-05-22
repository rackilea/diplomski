import com.opencsv._
import java.io._
import scala.collection.JavaConverters._
import scala.util._

object Main {

  val header: List[String] =
    List("Serial Number", "Record Type", "First File value", "Second file value")

  val columnOne: List[String] =
    List('1','2','3','4').map(_.toString)
  val columnTwo: List[String] =
    List("A","abhc","agch","mknk")
  val columnThree: List[String] =
    List("B", "gjgbn", "fgbhjf", "dfjf")

  val rows: List[List[String]] =
    columnOne.zip(columnTwo.zip(columnThree)).foldLeft(List.empty[List[String]]){
      case (acc, (a, (b, c))) => List(a, b, c) +: acc
    }.reverse

  def addPrefix(lls: List[List[String]]): List[List[String]] =
    lls.foldLeft((1, List.empty[List[String]])){
      case ((serial: Int, acc: List[List[String]]), value: List[String]) =>
        (serial + 1, (serial.toString +: value) +: acc)
    }._2.reverse

  def writeCsvFile(
    fileName: String,
    header: List[String],
    rows: List[List[String]]
  ): Try[Unit] =
    Try(new CSVWriter(new BufferedWriter(new FileWriter(fileName)))).flatMap((csvWriter: CSVWriter) =>
      Try{
        csvWriter.writeAll(
          (header +: rows).map(_.toArray).asJava
        )
        csvWriter.close()
      } match {
        case f @ Failure(_) =>
          // Always return the original failure.  In production code we might
          // define a new exception which wraps both exceptions in the case
          // they both fail, but that is omitted here.
          Try(csvWriter.close()).recoverWith{
            case _ => f
          }
        case success =>
          success
      }
    )

  def main(args: Array[String]): Unit = {
    println(writeCsvFile("/tmp/test.csv", header, addPrefix(rows)))
  }
}