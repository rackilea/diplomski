public void test() {
    ResultSet resultSet = null;
    // ...
    try {
        for (ResultSet r : in(new ResultSetIterator(resultSet))) {
            // We're there.
        }

    } finally {
        if (resultSet != null) {
            resultSet.close();
        }

    }
}