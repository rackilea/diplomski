class XPayService() {
    public static List<JobSearchItem> getJobAutocomplete(String searchValue) {
        String sValue = "%" + searchValue.toUpperCase() + "%";
        return dataUtilityService.getJdbcTemplate().query(SQL_GET_JOB_SEARCH_LISTS, 
                                    new Object[]{sValue, sValue}, jobSearchItemMapper);
    }
}

public void loadSearchList() throws SQLException, NamingException, URISyntaxException, IOException, ParseException {
    String searchData = "searchValue";
    List<JobSearchItem> jobSearchList = XPayService.getJobAutocomplete(searchData);
    this.setJobSearchItems(jobSearchList);
}