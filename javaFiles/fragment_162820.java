Throwable primaryExc = null;
Statement stmt = null;
try {
    stmt = con.createStatement();
    // use stmt here
} catch (Throwable e) {
    primaryExc = e;
    throw e;
} finally {
    if (stmt != null) {
        if (primaryExc != null) {
            try {
                stmt.close();
            } catch (Throwable ex) {
                primaryExc.addSuppressed(ex);
            }
        } else {
            stmt.close();
        }
    }
}