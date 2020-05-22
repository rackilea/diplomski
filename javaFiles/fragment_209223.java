val doubles2: Array<DoubleArray> = Array(2) { i ->
    DoubleArray(2) { j ->
        j + 1 * (i + 1).toDouble()
    }
}
//[[1.0, 2.0], [2.0, 3.0]]