val mapper = ObjectMapper()
val module = SimpleModule().addDeserializer(Error::class.java, ErrorDeserializer())
mapper.registerModule(module)

val error = mapper.readValue<Error>("json content", Error::class.java)
when (error) {
    is Error.SingleError -> {
        // error.errorMessage
    }
    is Error.MultiError -> {
        // error.errorMessage
    }
}