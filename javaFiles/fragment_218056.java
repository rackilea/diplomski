File f = new File(...);
If (f.exists()) {
    try (InputStream is = new FileInputStream(f);) {
        preparedStmt.setBinaryStream(24,is,f.length());
    }
} else
    preparedStmt.setNull(24, java.sql.Types.BLOB);