abstract class WeakDeserializer[T: Manifest] extends Serializer[T] {

//  final val tpe = implicitly[Manifest[T]]
//  final val clazz = tpe.runtimeClass

  // cannot serialize
  override def serialize(implicit format: Formats): PartialFunction[Any, JValue] = PartialFunction.empty
}

object StringToNumberDeserializer extends WeakDeserializer[Any] {

  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Any] = {

    case (TypeInfo(cc, _), JString(v)) =>
      cc match {
        case java.lang.Byte.TYPE => v.toByte
        case java.lang.Short.TYPE => v.toShort
        case java.lang.Character.TYPE => v.toInt.toChar
        case java.lang.Integer.TYPE => v.toInt
        case java.lang.Long.TYPE => v.toLong
        case java.lang.Float.TYPE => v.toFloat
        case java.lang.Double.TYPE => v.toDouble
        case java.lang.Boolean.TYPE => v.toBoolean
        //TODO: add boxed type
      }
  }
}

object ElementToArrayDeserializer extends WeakDeserializer[Any] {

  val listClass = classOf[List[_]]
  val seqClass = classOf[Seq[_]]
  val setClass = classOf[Set[_]]
  val arrayListClass = classOf[java.util.ArrayList[_]]

  override def deserialize(implicit format: Formats): PartialFunction[(TypeInfo, JValue), Any] = {

    case (ti@ TypeInfo(this.listClass, _), jv) =>
      List(extractInner(ti, jv, format))

    case (ti@ TypeInfo(this.seqClass, _), jv) =>
      Seq(extractInner(ti, jv, format))

    case (ti@ TypeInfo(this.setClass, _), jv) =>
      Set(extractInner(ti, jv, format))

    case (ti@ TypeInfo(this.arrayListClass, _), jv) =>
      import scala.collection.JavaConverters._

      new java.util.ArrayList[Any](List(extractInner(ti, jv, format)).asJava)

    case (ti@ TypeInfo(cc, _), jv) if cc.isArray =>
      val a = Array(extractInner(ti, jv, format))
      mkTypedArray(a, firstTypeArg(ti))
  }

  def mkTypedArray(a: Array[_], typeArg: ScalaType) = {
    import java.lang.reflect.Array.{newInstance => newArray}

    a.foldLeft((newArray(typeArg.erasure, a.length), 0)) { (tuple, e) => {
      java.lang.reflect.Array.set(tuple._1, tuple._2, e)
      (tuple._1, tuple._2 + 1)
    }}._1
  }

  def extractInner(ti: TypeInfo, jv: JValue, format: Formats): Any = {
    val result = extract(jv, firstTypeArg(ti))(format)
    result
  }

  def firstTypeArg(ti: TypeInfo): ScalaType = {
    val tpe = ScalaType.apply(ti)
    val firstTypeArg = tpe.typeArgs.head
    firstTypeArg
  }
}