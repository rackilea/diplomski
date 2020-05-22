case class MyData(id: String, startDate: String, endDate: String, list: List[String])
val inputData = Seq(("1_1", "2018-02-07", "2018-04-28"), ("1_2", "2018-05-06", "2018-05-31"), ("2_2", "2017-04-13", "2017-04-14"))
inputData.map(x => {
  import java.time.temporal._
  import java.time._
  val startDate = LocalDate.parse(x._2)
  val endDate = LocalDate.parse(x._3)
  val diff = ChronoUnit.MONTHS.between(startDate, endDate)
  var result = List[String]();
  for (index <- 0 to diff.toInt) {
    result = (startDate.getYear + "-" + (startDate.getMonth.getValue + index) + "-01") :: result
  }
  new MyData(x._1, x._2, x._3, result)
}).foreach(println)