Query query = session.createSQLQuery("SELECT Sum([qtyrequired]) as pcs, o.materialrequireddate, itemid  "
                + "FROM   [materialManagement].[pcsorderrequirement] r  JOIN materialmanagement.pcsorders o "
                + "ON o.id = r.pcsorderid  WHERE  itemid IN ( :items ) "
                + "AND Cast(o.materialrequireddate AS DATE) >= Cast(Getdate() AS DATE)  "
                + "AND o.materialrequireddate <= :endDate "
                + "GROUP  BY o.materialrequireddate, itemid").setParameterList("items", items.stream().map(Item::getId).collect(Collectors.toList()))
                .setDate("endDate", Date.from(endDate.atStartOfDay(ZoneId.systemDefault()).toInstant()));