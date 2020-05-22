val openConnection = URL(url).openConnection()
//if the image file is gzip
val bytes = if (openConnection.contentEncoding == "gzip") {
    GZIPInputStream(openConnection.getInputStream()).readBytes()
} else {
    openConnection.getInputStream().readBytes()
}
val file = File("e:\\text.jpg")
file.writeBytes(bytes)