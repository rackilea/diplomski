object Test extends App {
    val regex = """^NaN|-?(?:0(?:\.[0-9]*)?|(?:[1-9][0-9]*\.[0-9]*)|(?:\.[0-9]+))(?:[Ee][+-]?[0-9]+)?$""".r
    println(Seq("abc", "3", "3.0", "-3.0E-05", "NaN").map {
        case regex() => "Double"
        case _ => "String"
    })
}