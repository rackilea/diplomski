// configuration
SQLTemplates templates = MySQLTemplates.builder()
    .printSchema()
    .build();
Configuration configuration = new Configuration(templates);

// querying
SQLQuery sqlQuery = new SQLQuery(connection, configuration)
    .from(userPath).where(idPath.eq(1l)).limit(10);
sqlQuery.setUseLiterals(true);    
String query = sqlQuery.getSQL(usernamePath).getSQL();