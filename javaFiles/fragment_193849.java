finally {
    try {
        DBConnectionOrient.close(getAllBrandsPst,getAllBrandsResltSet);
    } catch (Exception e) {}
    try {
        DBConnectionOrient.close(dbConnection);
    } catch (Exception e) {}
}