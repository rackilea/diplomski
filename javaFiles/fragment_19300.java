val mainCount: Double
    val remainder = count % 50

    mainCount = count.toDouble() / 50
    val finalMainCount = if (remainder > 0) {
        mainCount.toInt() + 1
    } else {
        mainCount.toInt()
    }

    println(finalMainCount)

    return finalMainCount