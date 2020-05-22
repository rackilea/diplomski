fun printStringMessage(streamId: Int): FragmentHandler {
    val fragmentHandler = FragmentHandler { buffer: DirectBuffer, length: Int, offset: Int, header: Header ->
        val data = ByteArray(length)
        buffer.getBytes(offset, data)
        println(String.format("Message to stream %d from session %d (%d@%d) <<%s>>", streamId, header.sessionId(), length, offset, String(data)))
    }
    return fragmentHandler
}