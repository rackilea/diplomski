Cursor c = db.query(....);
try {

    // do all your cursor iteration in here

} finally {
    c.close();
}