val file = File("${cacheDir.path}/$fileName")

val dir = file.parentFile
dir.mkdirs()

val inputStream = assets.open(fileName).use { input ->
    val bufferedOutputStream = file.outputStream().buffered().use { output ->
        input.copyTo(output, 10240)
    }
}