package jacoffee.scalabasic

import java.time.{ ZoneId, LocalDateTime }
import java.util.Date

// package object defined is for Scala compiler to look for implicit conversion for case class parameter date
package object stackoverflow {
 implicit def toDate(ldt: LocalDateTime): Date =
   Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant())

 implicit def toLDT(date: Date): LocalDateTime =
   LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault())
}


package jacoffee.scalabasic.stackoverflow

import java.time.LocalDateTime
import java.util.Date
import net.liftweb.json.{ NoTypeHints, Serialization }
import net.liftweb.json.Serialization.{ read, write }


case class Child(var str: String, var Num: Int, var abc: Option[String],
 myList: List[Int], val date : Date = LocalDateTime.now()) {
   def getLDT: LocalDateTime = date
 }

object DateTimeSerialization extends App {
   implicit val formats = Serialization.formats(NoTypeHints)

   val ser = write(Child("Mary", 5, None, List(1, 2)))
// Child class converted to string {"str":"Mary","Num":5,"myList":[1,2],"date":"2015-07-21T03:07:05.699Z"}
   println(" Child class converted to string " + ser)

   var obj=read[Child](ser)
   // Object of Child is Child(Mary,5,None,List(1, 2),Tue Jul 21 11:48:22 CST 2015)
   println(" Object of Child is "+ obj)
   // LocalDateTime of Child is 2015-07-21T11:48:22.075
   println(" LocalDateTime of Child is "+ obj.getLDT)
}