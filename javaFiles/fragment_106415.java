log.debug(">>>>>> DatabaseMetaData Client Info Properties (jdbc driver)...");
ResultSet rsDmd = null;
try {
    boolean hasResults = false;
    rsDmd = dmd.getClientInfoProperties();
    while (rsDmd.next()) {
        hasResults = true;
        log.debug(">>>>>>>>> NAME = '" + rsDmd.getString("NAME") + "'; DEFAULT_VALUE = '" + rsDmd.getString("DEFAULT_VALUE") + "'; DESCRIPTION = '" + rsDmd.getString("DESCRIPTION") + "'");
    }
    if (!hasResults) {
        log.debug(">>>>>>>>> DatabaseMetaData Client Info Properties was empty (nothing returned by jdbc driver)");
    }
} catch (SQLException sqleDmd) {
    log.warn("DatabaseMetaData Client Info Properties (jdbc driver) not supported or no access to system tables under current id");
} finally {
    if (rsDmd != null) {
        rsDmd.close();
    }
}