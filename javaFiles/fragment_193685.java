import scala.reflect.runtime._
    import scala.reflect.runtime.universe._
    lazy val lengthOfAnnotation = p.annotations.find(_.tree.tpe == ru.typeOf[Len])
    val result = lengthOfAnnotation.flatMap { a =>
      a.tree.children.tail.head.collect({ case Literal(Constant(value)) => value }).headOption
    }
    lazy val maxLength = result.get.value.asInstanceOf[Int]