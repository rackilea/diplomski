<context>.select()
         .from(DSL.table("person"))
         .where(
             "identifier in ({0})", DSL.resultQuery(q)
         )
         .fetch();