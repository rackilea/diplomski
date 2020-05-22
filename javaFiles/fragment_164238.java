class Logger {

    companion object {

        private const val LOG_FILE_FOLDER = "Logs"
        private const val LOG_FILE_NAME = "transaction"
        private const val DATE_FORMAT = "yyyy-MM-dd"
        private val logFileName: String
            @SuppressLint("SimpleDateFormat")
            get() {

                var fileName = LOG_FILE_NAME
                val dateFormat = SimpleDateFormat(DATE_FORMAT)
                fileName += "_" + dateFormat.format(Date()) + ".json"
                return fileName
            }

fun logFile(json: Any) {

try {
    val directoryPath = Environment.getExternalStorageDirectory().path + "/" + LOG_FILE_FOLDER
    val loggingDirectoryPath = File(directoryPath)
    var loggingFile = File("$directoryPath/$logFileName")
    if (loggingDirectoryPath.mkdirs() || loggingDirectoryPath.isDirectory) {
        var isFileReady = true
        var isNewFile = false
        if (!loggingFile.exists()) {
            isFileReady = false
            try {
                loggingFile.createNewFile()
                isNewFile = true
                isFileReady = true
            } catch (e: Exception) {
                e.printStackTrace()
            }

        } else {
            val lastFile = getLastFile(loggingFile.name, directoryPath)
            loggingFile = File("$directoryPath/$lastFile")
            val fileSize = getFileSize(loggingFile)

        }
        if (isFileReady) {

            var jsonString: String? = null

            if (!isNewFile) {

                //Get already stored JsonObject
                val stream = FileInputStream(loggingFile)


                try {
                    val fileChannel = stream.channel
                    val mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size())

                    jsonString = Charset.defaultCharset().decode(mappedByteBuffer).toString()
                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    stream.close()
                }
            }


            //Create record object
            val record = if (!jsonString.isNullOrEmpty()) {
                Gson().fromJson(jsonString, Record::class.java)
            } else {
                Record()
            }


            //Append the current json
            record.recordList.add(json)

            //create json to save
            val jsonToSave = Gson().toJson(record)

            val bufferedOutputStream: BufferedOutputStream
            try {
                bufferedOutputStream = BufferedOutputStream(FileOutputStream(loggingFile))
                bufferedOutputStream.write(jsonToSave.toByteArray())
                bufferedOutputStream.flush()
                bufferedOutputStream.close()

            } catch (e4: FileNotFoundException) {
                e4.printStackTrace()
            } catch (e: IOException) {
                e.printStackTrace()
            } finally {
                System.gc()
            }
        }
    }
} catch (ex: Exception) {
    ex.printStackTrace()
}
}
}
}