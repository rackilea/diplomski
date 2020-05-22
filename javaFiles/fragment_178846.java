// Since you're not executing the SQL, set connection to null
Connection connection = null;
Factory create = new MySQLFactory(connection);
String sql1 = create.select(A, B, C)
                    .from(MY_TABLE)
                    .where(A.equal(5))
                    .and(B.greaterThan(8))
                    .getSQL();

String sql2 = create.insertInto(MY_TABLE)
                    .values(A, 1)
                    .values(B, 2)
                    .getSQL();

String sql3 = create.update(MY_TABLE)
                    .set(A, 1)
                    .set(B, 2)
                    .where(C.greaterThan(5))
                    .getSQL();