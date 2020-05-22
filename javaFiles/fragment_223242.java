// Kotlin
class Outer {
    inner class Inner: () -> Outer {
        override fun invoke() = this@Outer
    }
}
Outer().Inner().invoke()