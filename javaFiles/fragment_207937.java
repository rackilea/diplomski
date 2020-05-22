List<Integer> ids = ...
Configuration configuration = new DefaultConfiguration();
configuration.set(new Settings().withStatementType(StatementType.STATIC_STATEMENT));

String query = DSL.using(configuration)
                  .select(TABLE.SOMETHING)
                  .from(TABLE)
                  .where(TABLE.ID.in(ids))
                  .getSQL();