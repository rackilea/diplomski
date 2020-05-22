import scala.util.{Try, Success}

def parseAll(csvFiles: Iterable[String], sc: SparkContext): RDD[Document] = {
  val csv = sc.textFile(csvFiles mkString ",")

  val docs = csv.filter(!_.contains(headerPart))
    .map(s => Try(buildDocument(s)))
    .collect { case Success(v) => v }

  docs
}