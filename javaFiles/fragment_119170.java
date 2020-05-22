... stmt = session.createSQLquery("delete from ( ... fetch first 50 rows only )");
int n = 1
while (n > 0) {
    transaction = session.beginTransaction();
    n = stmt.executeUpdate();
    transaction.commit();    
}