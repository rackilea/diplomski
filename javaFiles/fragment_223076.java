try {
    writeToDatabase();
} catch(Exception ex) {
    rollbackChanges();
    throw ex;
}