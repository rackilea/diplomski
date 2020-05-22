public static List getList(Class entity, String order, Boolean reverseOrder, Boolean enabled) {
    // stripped for brevity...
    list = session.createCriteria(entity)
                            .add(Restrictions.eq("enabled", true))
                            .addOrder(Order.asc(order)).list();
    // stripped more...
    return list;
    }