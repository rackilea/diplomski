class FooBar(val x: String, val y: String)
object FooBar {
    def apply(z: String) = {
        // DO SOME ARBITRARY CODE
        val x = // SOME ARBITRARY PROCESSING USING z
        val y = // SOME ARBITRARY PROCESSING USING z
        new FooBar(x, y)
    }
}

FooBar(someZ)