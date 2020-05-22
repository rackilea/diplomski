try {
    // Dodgy database code here
catch (IOException|SQLException ex) {
    logger.log(ex);
    throw ex;
}