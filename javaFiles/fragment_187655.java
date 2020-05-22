SQLQuery query = sess.createSQLQuery("SELECT * FROM ? WHERE ? = '?'");

query
    .addEntity(klass)
    .setParameter(0, table)
    .setParameter(1, field)
    .setParameter(2, value)
    .uniqueResult();