private fun dbcopy(context: Context) {

    val dbfile = File(context.getDatabasePath(DATABASE_NAME).path)
    if (!dbfile.parentFile.exists()) {
        dbfile.parentFile.mkdirs()
    }
    try {
        val os = FileOutputStream(dbfile)
        // and so on
    } catch (e: IOException) {

    }

}