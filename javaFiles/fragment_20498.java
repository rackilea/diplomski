List<String> lastnames= new ArrayList<>();

Map namedParameters = Collections.singletonMap("lastnamevalues", lastnames);

StringBuffer recordQueryString = new StringBuffer();

recordQueryString.append("select FIRSTNAME, LASTNAME from ACTORS where lastname in (:lastnamevalues)");

List nameInvolvements = this.namedparameterJdbcTemplate.query(recordQueryString.toString(), namedParameters, new MyMapper());