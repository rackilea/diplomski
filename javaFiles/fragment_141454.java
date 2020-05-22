class EnumSerializer[E <: Enum[E]](implicit ct: Manifest[E]) extends CustomSerializer[E](format ⇒ ({
  case JString(name) ⇒ Enum.valueOf(ct.runtimeClass.asInstanceOf[Class[E]], name)
}, {
  case dt: E ⇒ JString(dt.name())
}))



// first enum I could find
case class X(a: String, enum: java.time.format.FormatStyle)
implicit val formats = DefaultFormats + new EnumSerializer[java.time.format.FormatStyle]()

// {"a":"test","enum":"FULL"}
val jsonString = Serialization.write(X("test", FormatStyle.FULL))
Serialization.read[X](jsonString)