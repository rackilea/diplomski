ResultSet updates = connectionObject.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE).executeQuery("select id, foo1, foo2 from footable);
updates.moveToInsertRow();
updates.updateInt(1, 34); // updates id
updates.updateString(2, "bar"); // updates foo1
updates.updateBoolean(3, true); // updates foo2
updates.insertRow();
connectionObject.commit();