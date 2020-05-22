case class MyParams(msg: String, url: String, userId: Int)

parameters(
  "msg".as[String],
  "url".as[String],
  "userId".as[Int]
).as[MyParams] {
  myParams => 
   // Here you have the case class containing all the data, already parsed.
}