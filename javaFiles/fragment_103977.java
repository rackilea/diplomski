trait FromString[T] { 
   def convert(s: String): T
   def apply(s: String): Option[T] = Try(convert(s.trim)).toOption
 }

 implicit object IntFromString extends FromString[Int] {
   def convert(s: String) = s.toInt
 }
 implicit object DoubleFromString extends FromString[Double] {
   def convert(s: String) = s.toDouble
 } 
 // etc.