try (ResultSet res = stmt.executeQuery(query)) {
    while (res.next()) {
        versionNo = res.getInt(1);
        if (res.wasNull()) {
            // whatever you want to, other than setting versionNo to 0
        }
    }
}