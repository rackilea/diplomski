Session session = sessionFactory.getCurrentSession();

final DateFormat df = new SimpleDateFormat("yy-MM-dd");

// omitting the time part will set the time to midnight (00:00:00)
Timestamp start = new Timestamp(df.parse("13-02-02").getTime());
Timestamp end = new Timestamp(df.parse("17-02-02").getTime());

try {
    String hql = 
        "select Count(*) from mytable where PERIOD_START_DATETIME between ? AND ?";
    Query query = session.createQuery(hql)
            .setTimestamp(0, start)
            .setTimestamp(1, end);

    long count = (long) query.uniqueResult();

    return count;
} finally {
    session.close();
}