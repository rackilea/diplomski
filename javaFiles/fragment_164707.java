implicit val typeReference = new TypeReference[MyGeneric[MyComplexType]] {}
  val value = foo(jsonString)
  println(value.myValue.name)


  def foo[T](jsonStr: String)(implicit typeReference: TypeReference[MyGeneric[T]]): MyGeneric[T] = {
    val objectMapper = new ObjectMapper()
    objectMapper.readValue(jsonStr, typeReference)
  }