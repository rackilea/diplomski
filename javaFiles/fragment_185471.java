interface Thingy {
    fun foo() : Boolean
    fun bar() : Boolean
}

class ThingyTest {
    @Test
    fun test() {
        val t1 = mock<Thingy>(defaultAnswer = Answer { false })
        println(t1.foo())   // "false"
        println(t1.bar())   // "false"

        val t2 = mock<Thingy>(defaultAnswer = Answer { true })
        println(t2.foo())   // "true"
        println(t2.bar())   // "true"
    }
}