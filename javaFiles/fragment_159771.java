/**
  * Scala Functions masquerading as Java 8 Lambdas.
  *
  * (C) Justin Johansson 2015.
  *
  * Microblogging about my Project Clockwork, a
  * new implementation of XPath/XQuery on the JVM,
  * as @MartianOdyssey on Twitter (https://twitter.com/MartianOdyssey).
  *
  * Permission to use this code is granted under Apache License,
  * Version 2.0 and providing attribution is afforded to author,
  * Justin Johansson.
  */

package lab

import scala.language.implicitConversions

import java.util.{ Arrays => JArrays, List => JList }
import java.util.function.{ Consumer => JConsumer, Function => JFunction, Predicate => JPredicate }
import java.util.stream.{ Stream => JStream }

object JLambda extends App {
  println("JLambda: Scala to Java 8 lambda test")

  implicit def func1ToJConsumer[T](func: T => Unit): JConsumer[T] = {
    new JConsumer[T] {
      def accept(arg: T): Unit = func(arg)
    }
  }

  implicit def func1ToJFunction[T, R](func: T => R): JFunction[T, R] = {
    new JFunction[T, R] {
      def apply(arg: T): R = func(arg)
    }
  }

  implicit def func1ToJPredicate[T](func: T => Boolean): JPredicate[T] = {
    new JPredicate[T] {
      def test(arg: T): Boolean = func(arg)
    }
  }

  val myList = JArrays.asList("cake", "banana", "apple", "coffee")
  println(s"myList = $myList")

  val myListFiltered: JStream[String] = myList.stream
    .filter { x: String => x.startsWith("c") }

  val myListFilteredAndMapped: JStream[String] = myListFiltered
    .map { x: String => x.toUpperCase }

  myListFilteredAndMapped.forEach { x: String => println(s"x=$x") }
}


/*
Outputs:
JLambda: Scala to Java 8 lambda test
myList = [cake, banana, apple, coffee]
x=CAKE
x=COFFEE
*/