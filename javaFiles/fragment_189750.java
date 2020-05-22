// say you have three byte arrays
val ba1 = ByteArray(3) { it.toByte() }
val ba2 = ByteArray(3) { (it + 3).toByte() }
val ba3 = ByteArray(3) { (it + 6).toByte() }

// make a list of them like so
val allByteArray = listOf(ba1, ba2, ba3)