annotation class Test(
    val value: String
)

object Keys {
    const val API_KEY = "AB"
}

@Test(Keys.API_KEY)
fun doSomething() {

}