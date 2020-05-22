import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import scala.io.Source
import java.io.File

  val sc = new SparkContext("your_spark_master", "your_application_name")
  // Read from a local dir
  val sourceRecords = new File("your_dir_path").listFiles().flatMap(file => Source.fromFile(file).getLines.toList).filter(_.length > 0)
  val sourceRecordsBc = sc.broadcast(sourceRecords)
  val inputRDD = sc.textFile("hdfs://your_input_path")
  val outputRDD = inputRDD.filter { _.length > 0 }
    .map { line => (line, line.split(",")) }
    .filter { _._2.size == 21 }
    .flatMap {
      case (line, target) => {
        val pos_last_name = 0
        for (
          inputLine <- sourceRecordsBc.value if inputLine != line;
          val source = inputLine.split(",") if source.size == 21 && source(pos_last_name) == target(pos_last_name)
        ) yield (inputLine, line)
      }
    }
  outputRDD.saveAsTextFile("hdfs://your_output_path")