class XPayService() {
    public List<JobSearchItem> getJobAutocomplete(String searchValue) {
        String sValue = "%" + searchValue.toUpperCase() + "%";
        return dataUtilityService.getJdbcTemplate().query(SQL_GET_JOB_SEARCH_LISTS, 
                                    new Object[]{sValue, sValue}, jobSearchItemMapper);
    }
}

public void loadSearchList() throws SQLException, NamingException, URISyntaxException, IOException, ParseException {
    XPayService xps = new XPayService();
    String searchData = "searchValue";
    List<JobSearchItem> jobSearchList = xps.getJobAutocomplete(searchData);
    this.setJobSearchItems(jobSearchList);
}