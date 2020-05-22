object JacksonSerializerHelpers {
  implicit val mapper = new ObjectMapper() with ScalaObjectMapper
  mapper.registerModule(DefaultScalaModule)
  implicit class JacksonSerializer(val any: Any) {
    def toJsonString(implicit mapper: ObjectMapper): String = {
      val out = new StringWriter
      mapper.writeValue(out, any)
      out.toString()
    }
   }
}

import JacksonSerializerHelper.JacksonSerializer
Ok("{}".toJsonString)