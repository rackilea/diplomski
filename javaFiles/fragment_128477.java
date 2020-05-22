try (ResultSet res = stmt.executeQuery(query)) {
    if (res.next()) {
       do {
           versionNo = res.getInt(1);
       } while (res.next());
    } else {
        // no rows
    }
}