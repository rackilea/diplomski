scala> val df = Seq(("{a=6236.0, b=0.0}"),("{a=323, b=2.3} ")).toDF("data")
df: org.apache.spark.sql.DataFrame = [data: string]

scala> import org.apache.spark.sql.types._
import org.apache.spark.sql.types._

scala> val sch1 = new StructType().add($"a".string).add($"b".string)
sch1: org.apache.spark.sql.types.StructType = StructType(StructField(a,StringType,true), StructField(b,StringType,true))

scala> def  json1(x:String):String=
     | {
     |  val coly = x.replaceAll("[{}]","").split(",")
     |  val cola = coly(0).trim.split("=")
     |  val colb = coly(1).trim.split("=")
     |  "{\""+cola(0)+"\":"+cola(1)+ "," + "\"" +colb(0) + "\":" + colb(1) + "}"
     | }
json1: (x: String)String

scala>  val my_udf = udf( json1(_:String):String )
my_udf: org.apache.spark.sql.expressions.UserDefinedFunction = UserDefinedFunction(<function1>,StringType,Some(List(StringType)))

scala> df.withColumn("n1",my_udf('data)).select(from_json($"n1",sch1) as "data").select("data.*").show(false)
+------+---+
|a     |b  |
+------+---+
|6236.0|0.0|
|323   |2.3|
+------+---+


scala>