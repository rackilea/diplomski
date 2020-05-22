data class Row(val n: Int, val m: Int, val t1: String, val t2: String) {
    val ig: Int = (n * (n + 1)) / 2 + m + 1
}

// rowList is List<Row> after parsing
val maxIdx = rowList.maxBy { it.ig } ?: -1

val cc = arrayOfNulls<String>(maxIdx + 1)
val cs = arrayOfNulls<String>(maxIdx + 1)

for (row in rowList) {
    cc[row.ig] = row.t1
    cs[row.ig] = row.t2
}