import java.util.LongSummaryStatistics

def main(): Unit = {
  val l = List(("s1", 1L), ("s2", 2L), ("s3", 3L), ("s4", 4L))
  // .view here is a trick to make it semantically more similar to Java Streams i.e. to avoid materializaiton of the mapped list
  val stats = summaryStatistics(l.view.map(_._2))
  println("min: %d, max: %d, avg: %f".format(stats.getMin, stats.getMax, stats.getAverage))
}


def summaryStatistics(col: TraversableOnce[Long]): LongSummaryStatistics = {
  col.foldLeft(new LongSummaryStatistics)((stat, el) => {
    stat.accept(el)
    stat
  })
}