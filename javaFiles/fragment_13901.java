} finally {
    if (connet != null) {
        try {
            connet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    ...
}