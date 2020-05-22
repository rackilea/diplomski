jooq.createIndex("covering_index")
     .on(NODES, 
         NODES.START_INDEX, 
         NODES.END_INDEX
         NODES.LEVEL)
     .execute();