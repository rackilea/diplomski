sealed class Error() {
    data class SingleError(val errorMessage: String) : Error()
    data class MultiError(val errorMessage: Map<String, String>) : Error()
}
...
class ErrorDeserializer : StdDeserializer<Error>(Error::class.java) {

    companion object {
        private val MAP_TYPE_REFERENCE = object : TypeReference<Map<String, String>>() {}
    }

    @Throws(IOException::class, JsonProcessingException::class)
    override fun deserialize(jp: JsonParser, ctxt: DeserializationContext): Error {
        val mapper = jp.codec as ObjectMapper
        val node: JsonNode = mapper.readTree(jp)
        val msgNode = node.get("errorMessage")
        if (msgNode.isValueNode) {
            val errorMsg = msgNode.asText()
            return Error.SingleError(errorMsg)
        } else {
            val errorMsgs = mapper.readValue<Map<String, String>>(msgNode.toString(), 
                    MAP_TYPE_REFERENCE)
            return Error.MultiError(errorMsgs)
        }
    }
}