fun testString(s: Any)
{
    when(s)
    {
        is Int -> println("Int parameter!")
        is String -> println("String parameter!")
        is Boolean -> println("boolean thing!")
        else -> println("Other object!")
    }
}