fun get(url: String): String {
        try {
            val connection = URI(url).toURL().openConnection() as HttpURLConnection
            connection.connect()
            val text = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
            return text
        } catch (e: IOException) {
            Log.e("Error: ", "" + e)
        }
        return ""
    }

    fun getImage(url: String): InputStream? {
        try {
            val connection = URI(url).toURL().openConnection() as HttpURLConnection
            connection.connect()
            return BufferedInputStream(connection.inputStream)
        }catch(e: FileNotFoundException){
            e.printStackTrace()
        }
        return null
    }