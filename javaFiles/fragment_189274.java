private val HEX_ARRAY = "0123456789ABCDEF".toCharArray()

fun bytesToHex(bytes: ByteArray): String {
    val hexChars = CharArray(bytes.size * 2)
    for (j in bytes.indices) {
        val v = bytes[j].toInt() and 0xFF // Here is the conversion
        hexChars[j * 2] = HEX_ARRAY[v.ushr(4)]
        hexChars[j * 2 + 1] = HEX_ARRAY[v and 0x0F]
    }

    return String(hexChars)
}

fun main(args: Array<String>) {
    val s = "hello_world"
    println(bytesToHex(s.toByteArray(Charset.forName("UTF-8"))))
}