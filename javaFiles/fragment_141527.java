fun printStringMessage(streamId: Int): FragmentHandler {
    return FragmentHandler { buffer, length, offset, header ->
        val data = ByteArray(length)
        buffer.getBytes(offset, data)
        println(String.format("Message to stream %d from session %d (%d@%d) <<%s>>", streamId, header.sessionId(), length, offset, String(data)))
    }
}