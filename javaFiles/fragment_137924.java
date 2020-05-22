val hello = Hello()
val f = Hello::class.memberProperties.find { it.name == "world" }
f?.let {
    it.isAccessible = true
    val w = it.get(hello) as World
    println(w.foo())
}