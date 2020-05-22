DSL.using(configuration)
   .select(ORDERS.LABEL, ORDERS.ORDERDATE, ORDERS.PRIC)
   .from(ORDERS)
   .where(row(ORDERS.LABEL, ORDERS.ORDERDATE)
       .in(select(ORDERS.LABEL, max(ORDERS.ORDERDATE))
            .from(ORDERS)
            .groupBy(ORDERS.LABEL)))
   .fetch();