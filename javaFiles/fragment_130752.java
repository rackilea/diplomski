fun readFromFile(context: Context, fileName: String): String {
  return try {
                FileInputStream(File(context.applicationContext.filesDir, fileName)).bufferedReader()
                    .use { it.readText() }
            } catch (e: Exception) {
                println("it is checking point of Error read file " + e.message)
                ""
            }

        }

fun writeToFile(context: Context, fileName: String, data: String = "") {
            try {
                FileOutputStream(File(context.applicationContext.filesDir, fileName)).use {
                    it.write(data.toByteArray())
                }
            } catch (e: FileNotFoundException) {
                println("it is checking point of Error write file " + e.message)
            }
        }