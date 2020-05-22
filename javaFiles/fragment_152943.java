val length = 20 // Some default length
val cc = arrayOfNulls<String>(length)
val cs = arrayOfNulls<String>(length)

val lineRegex = "\\s+".toRegex()

File("4Column_file.txt").useLines { lineSequence ->
    for (line in lineSequence) {
        val (n, m, t1, t2) = line.split(lineRegex)
        val nInt = n.toInt()
        val mInt = m.toInt()

        val ig = (nInt * (nInt + 1)) / 2 + mInt + 1
        cc[ig] = t1
        cs[ig] = t2
    }
}