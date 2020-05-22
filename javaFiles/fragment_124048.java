class StackOverflowTest {
    public data class Dog(public var name: String, public var age: Double)

    @Test public fun testSimpleDeser() {
        val dogObj = Dog("Avi", 1.5)
        val expectedJson = """{"name":"Avi","age":1.5}"""

        assertEquals(expectedJson, ObjectMapper().writeValueAsString(dogObj))
        assertEquals(expectedJson, jacksonObjectMapper().writeValueAsString(dogObj))
    }
}