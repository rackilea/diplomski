Connection con = null;
boolean ok = false;
try {
    con = DriverManager.getConnection(...);
    ...
    con.commit();
    ok = true;
} catch (...) {
    // diagnose exception 
} 
...
} finally {
    if (con != null) {
        try {
            if (!ok) con.rollback();
        } finally {
           con.close();
        }
    }
}