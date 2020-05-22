TableRecord randomRecord =
DSL.using(configuration)
   .select()
   .from(TABLE)
   .limit(1)
   .fetchOne();