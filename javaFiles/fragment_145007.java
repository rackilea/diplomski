abstract class Operator(symbol: String, // no val here, only pass to super class
      val binaryOp: (Double, Double) => Double) extends Node(symbol) {
}

class Add(val a: Number, val b: Number) extends 
  Operator("+", (a: Double, b: Double) => a+b ) {
}