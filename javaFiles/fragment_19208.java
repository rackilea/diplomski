val url = URL("https://www.google.com")
val connection = url.openConnection() as? HttpURLConnection ?: return
connection.connect()

val inputStream = connection.inputStream
val content = inputStream.bufferedReader().use { it.readText() }

println("${content.length} is the length")