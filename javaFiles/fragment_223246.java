// Kotlin
class Outer {
    fun inner(string: String): () -> String {
        var string2 = string
        return { string2 }
    }
}
Outer().inner("").invoke()