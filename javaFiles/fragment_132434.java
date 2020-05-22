stmt.execute(fq.getQuery());

ResultSet rs = null;

for (;;) {
    rs = stmt.getResultSet();
    while (rs.next()) {
        System.out.println(rs.getString("MyColumn"));
    }
    if ((stmt.getMoreResults() == false) && (stmt.getUpdateCount() == -1)) {
        break;
    }
}

if (rs != null) {
    rs.close();
}