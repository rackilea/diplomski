Session session = null;
    List<Object[]> catalogStores = new ArrayList();
    try {
        session = this.sessionFactory.openSession();
        catalogStores = session.createSQLQuery("select \n" +
                "    t1.name as goodsName,\n" +
                "    t3.name as companyName,\n" +
                "    sum(t2.amount) as amountSum,\n" +
                "    t3.price as priceOneGoods,\n" +
                "    (t1.price * sum(t2.amount)) as summ \n" +
                "from\n" +
                "    store_catalog t1\n" +
                "        inner join\n" +
                "    commission t2 ON (t1.id = t2.idGoodsStore)\n" +
                "        inner join\n" +
                "    company_catalog t3 ON (t3.id = t2.idGoodsCompany)\n " +
                "       inner join\n" +
                "   store t4 ON (t1.idStore = " + idStore + ")\n " +
                "group by t1.id")
                .addScalar("goodsName", new StringType())
                .addScalar("companyName", new StringType())
                .addScalar("amountSum", new IntegerType())
                .addScalar("priceOneGoods", new DoubleType())
                .addScalar("summ", new DoubleType())
                .list();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (session != null && session.isOpen())
            session.close();
    }
    return catalogStores;