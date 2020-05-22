// warmup
for (i in 1..9999) {
    val list = (1..100000).toList()
    list.filter { it % 7 == 0 }
}

// rest of the test