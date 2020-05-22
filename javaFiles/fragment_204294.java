session.createSQLQuery("select ...")
    .addScalar("achievement", IntegerType.INSTANCE)
    .addScalar("mistake", IntegerType.INSTANCE)
    .addScalar("total", IntegerType.INSTANCE)
    .setResultTransformer(Transformers.aliasToBean(RecordFormHomePage.class))
    .list();