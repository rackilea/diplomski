import scala.util._
def modifyField( obj: AnyRef, name: String, value: Any ) {
  def impl(clazz: Class[_] ) {
    Try(clazz.getDeclaredField(name)).toOption match {
      case Some(field) => 
        field.setAccessible(true)
        clazz.getMethod(name).invoke(obj) // force init in case it's a lazy val
        field.set(obj, value) // overwrite value
      case None => 
        if (clazz.getSuperclass != null) {
          impl(clazz.getSuperclass)
        }
    }
  }
  impl(obj.getClass)
}