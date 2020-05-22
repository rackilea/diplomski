public List<GoogleMapHelper> getAddressForGoogleMap() {
    String sql = "Select city, state, country FROM dbo.Customerdetails ";
    SQLQuery query = getSession().createSQLQuery(sql);
    query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
    List data = query.list();
    List<GoogleMapHelper> address = new ArrayList<GoogleMapHelper>();
    for (Object object : data) {
        GoogleMapHelper googleHelper = new GoogleMapHelper();
        Map row = (Map) object;
        googleHelper.setCity(row.get("city").toString());
        googleHelper.setState(row.get("state").toString());
        googleHelper.setCountry(row.get("country").toString());
        address.add(googleHelper);
    }
    return address;
}