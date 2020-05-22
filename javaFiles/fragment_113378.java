public static void testExists() {
    Logger console = LogManager.getLogger(getClass()); 
    Logger dbLog = LogManager.getLogger("sptestlog"); // match config Logger name!

    console.info("== write this to the console ==");
    dbLog.info("== write this to the db2 log ==");
}