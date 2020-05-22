public Set<CountryFirstData> sortCountryFirst() throws SQLException {

    long parsingStart = System.nanoTime();

    SortedMap<CountryFirstData, CountryFirstData> identityMap = new TreeMap<>();
    //      Comparator.comparing(CountryFirstData::getCountry)
    //          .thenComparing(CountryFirstData::getSerie))
    //          .thenComparing(CountryFirstData::getUnit));

    while (rs.next()) {

        String serie = rs.getString(1); // rs is the previously built resultSet
        String unit = rs.getString(2);
        Stribg country = rs.getString(3);
        BigDecimal value = rs.getBigDecimal(4);
        int year = rs.getInt(5);
        CountryFirstData data = new CountryFirstData(country, serie, unit));
        CountryFirstData oldData = identityMap.putIfAbsent(data, data);
        if (oldData != null) {
            data = oldData;
        }
        data.getDuo().add(new YearValueDuo(year, value));
    }
    long parsingEnd = System.nanoTime();

    System.out.println("Parsing Time = " + ((parsingEnd - parsingStart)/1_000_000_000L));

    return (SortedSet<CountryFi‌​rstData>) identityMap.keySet()‌​;
}