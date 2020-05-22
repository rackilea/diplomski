import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.wikiedits.WikipediaEditsSource
import org.apache.flink.streaming.api.windowing.time.Time

object WikipediaAnalytics extends App {
  val see: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
  val edits = see.addSource(new WikipediaEditsSource())
  val userEditsVolume: DataStream[(String, Int)] = edits
    .keyBy(_.getUser)
    .timeWindow(Time.seconds(5))
    .fold(("", 0))((acc, event) => (event.getUser, acc._2 + event.getByteDiff))
  userEditsVolume.print()
  see.execute("Wikipedia User Edit Volume")
}