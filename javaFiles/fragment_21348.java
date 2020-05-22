class NiceObject[T <: AnyRef](x : T) {
  def niceClass : Class[_ <: T] = x.getClass.asInstanceOf[Class[T]]
}

implicit def toNiceObject[T <: AnyRef](x : T) = new NiceObject(x)

scala> "Hello world".niceClass                                       
res11: java.lang.Class[_ <: java.lang.String] = class java.lang.String