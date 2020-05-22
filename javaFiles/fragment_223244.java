// Kotlin
class Outer {
    var string: String = ""
    inner class Inner: () -> String {
        override fun invoke() = string
    }
}
Outer().Inner().invoke()