try (ResultSet res = stmt.executeQuery(query)) {
    versionNo = 0;
    while (res.next()) {
        versionNo = res.getInt(1);
    }
}