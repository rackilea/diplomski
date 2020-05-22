import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
import org.apache.spark.rdd.RDD

case class Address(city:String, block:String);
case class Person(name:String,age:String, address:Address);
object Test2 {
  def main(args: Array[String]): Unit = {

     val conf = new SparkConf().setAppName("Simple Application").setMaster("local");
      val sc = new SparkContext(conf)
      val sqlContext = new org.apache.spark.sql.SQLContext(sc);
      import sqlContext.implicits._
      val people = sc.parallelize(List(Person("a", "b", Address("a", "b")), Person("c", "d", Address("c", "d"))));

      val df  = sqlContext.createDataFrame(people);
      df.write.mode("overwrite").parquet("/tmp/people.parquet")
  }
}