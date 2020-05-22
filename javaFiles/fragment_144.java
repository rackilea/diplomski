interface SomeInterface {
    val someList: List<Int>
}

internal class SomeClass : SomeInterface {
    override val someList: MutableList<Int> = mutableListOf()
}

fun getSomeInterface(): SomeInterface =
    SomeClass().apply { someList += listOf(1, 2, 3) }