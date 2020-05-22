if (version <= 1) {
    onCreate(db)
}

if (version <= 2) {
    db.execSQL("CREATE TABLE IF NOT EXISTS ")
    db.execSQL("CREATE TABLE IF NOT EXISTS ")
}