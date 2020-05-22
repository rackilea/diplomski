val allByteArray = ArrayList<ByteArray>()
for (i in 0 until 3) {
    // some byte array
    val ba = ByteArray(3) { (it + (i*3)).toByte() }

    // add to list
    allByteArray.add(ba)
}