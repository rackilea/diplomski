private fun installDatabaseFromAssets() {
    val inputStream = context.assets.open("$ASSETS_PATH/$DATABASE_NAME.db")
    val dbFile = File(context.getDatabasePath(DATABASE_NAME).toString())
    if (!dbFile.exists()) {
        if (!dbFile.parentFile.exists()) {
            dbFile.parentFile.mkdirs()
        }
    }
    try {
        //val outputFile = File(context.getDatabasePath(DATABASE_NAME).path)
        val outputStream = FileOutputStream(dbFile)

        inputStream.copyTo(outputStream)
        inputStream.close()
        outputStream.flush()
        outputStream.close()
    } catch (exception: Throwable) {
        throw RuntimeException("The $DATABASE_NAME database couldn't be installed.", exception)
    }
}