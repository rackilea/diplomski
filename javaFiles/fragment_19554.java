private fun checkDataBase(context: Context): Boolean {

    val db = File(context.getDatabasePath(DATABASE_NAME).path) //Get the file name of the database
    if (db.exists()) return true // If it exists then return doing nothing

    val dbdir = db.parentFile
    // If the directory does not exist then make the directory (and higher level directories)
    if (!dbdir.exists()) {
        db.parentFile.mkdirs()
        dbdir.mkdirs()
    }
    return false
}