@Override
    public Country map(final int index, final ResultSet resultRow, final StatementContext ctx) throws SQLException {

        final String countryIso3Code = resultRow.getString("iso3Code");
        if (countryIso3Code == null) {
            throw new SQLDataException("Iso3Code is required");
        }
        Country country = (Country)ctx.getAttribute(countryIso3Code);
        if (country == null) {
            country = new Country();
            country.setName(resultRow.getString("name"));
            country.setIso3Code(countryIso3Code);
            country.setIso2Code(resultRow.getString("iso2Code"));
            ctx.setAttribute(countryIso3Code, country);
        }

        String region = resultRow.getString("region");
        if (region != null) {
            country.addRegion(region);
        }
        return country;
    }