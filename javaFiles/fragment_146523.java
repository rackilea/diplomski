private fun gifDrawableToFile(gifDrawable: GifDrawable, gifFile: File) {
    val byteBuffer = gifDrawable.buffer
    val output = FileOutputStream(gifFile)
    val bytes = ByteArray(byteBuffer.capacity())
    (byteBuffer.duplicate().clear() as ByteBuffer).get(bytes)
    output.write(bytes, 0, bytes.size)
    output.close()
}