(new {
    def foo : Unit = println("Called foo method")
} : Any) match {
    case f : {def foo : Unit} ⇒
        println("Has foo method")
        f.getClass.getDeclaredMethods
}