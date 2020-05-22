trait Expr

case class Const(val value: Int) extends Expr
case class Add(val left: Expr, val right: Expr) extends Expr

def evaluate(exp: Expr): Int = exp match {
    case Const(cv) => cv
    case Add(exp1, exp2) => evaluate(exp1) + evaluate(exp2)
    case _ => throw new IllegalArgumentException("did not understand: " + exp)
}