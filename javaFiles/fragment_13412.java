<context>.select()
         .from(DSL.table("person"))
         .where(DSL.field("identifier").in(
             DSL.select().from("(" + q + ")")
         ))
         .fetch();