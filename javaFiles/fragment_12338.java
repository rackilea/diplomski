private String generateSQLWithWhereInInline(String... businessGroupProcesses) {
    Settings settings = new Settings()
        .withStatementType(StatementType.STATIC_STATEMENT);

    return DSL.using(SQLDialect.ORACLE, settings);
              .selectDistinct(
                    field(name("Business Group")).as("Business_Group"))
              .from(table(name("SOME_TABLE")))
              .where(field(name("Business Group Process"))
                    .in(businessGroupProcesses))
              .getSQL();
}