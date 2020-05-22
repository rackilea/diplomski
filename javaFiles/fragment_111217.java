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