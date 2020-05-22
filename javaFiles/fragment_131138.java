public List<CountryFirstData> sortCountryFirst() throws SQLException {

    long parsingStart = System.nanoTime();

    List<CountryFirstData> identityMap = new ArrayList<>();
    CountryFirstData oldData = null;
    while (rs.next()) {
        String serie = rs.getString(1); // rs is the previously built resultSet
        String unit = rs.getString(2);
        Stribg country = rs.getString(3);
        BigDecimal value = rs.getBigDecimal(4);
        int year = rs.getInt(5);
        CountryFirstData data = new CountryFirstData(country, serie, unit));
        if (oldData == null || data.compareTo(oldData) != 0) {
            oldData = data;
            list.add(data);
        }
        oldData.getDuo().add(new YearValueDuo(year, value));
    }
    long parsingEnd = System.nanoTime();

    System.out.println("Parsing Time = " + ((parsingEnd - parsingStart)/1_000_000_000L));

    return list;
}