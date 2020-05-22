String sSql = "CREATE TABLE [ ? ].[ ? ].[ ? ] (?)";
Query q = session.createQuery(sSql);
q.setString(0, sDatabaseName)
 .setString(1, sSchema)
 .setString(2, sTableName)
 .setString(3, sSqlFields )
 .executeUpdate();