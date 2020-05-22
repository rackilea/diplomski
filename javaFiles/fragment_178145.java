listOf(1, 2, 3, 4, 5)
    .asSequence()
    .filter { it < 3 }
    .onEach { println("filtered $it") }
    .map { it * 10 }
    .forEach { println("final: $it") }