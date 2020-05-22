List<Integer> ids = ...

String query = DSL.using(configuration) // Use a Configuration or at least a SQLDialect!
                  .select(TABLE.SOMETHING)
                  .from(TABLE)
                  .where(TABLE.ID.in(ids.stream().map(DSL::inline).collect(toList())))
                  .getSQL();