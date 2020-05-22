List<Integer> ids = ...

String query = DSL.using(configuration)
                  .select(TABLE.SOMETHING)
                  .from(TABLE)
                  .where(TABLE.ID.in(ids))
                  .getSQL(ParamType.INLINED);