arr.asSequence().filter { i ->
    println("Filter: $i")
    i % 2 == 0
}.take(2).toList()

//Filter: 0
//Filter: 1
//Filter: 2