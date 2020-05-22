try {
    stmt = conn.prepareStatement( 
      "insert into TEST (ID,STR_TEST1) values (setval('test_id_seq'),?)")

    for (String element : someList) {
        stmt.setString(1, element)
    }
    stmt.executeBatch();
    conn.commit()
} finally {
    stmt.close()
}