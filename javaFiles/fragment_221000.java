try {
    if (resultSet != null) {
        resultSet.close();
    }

    if (connect != null) {
        connect.close();
    }
} catch (Exception e) {

}