protected <T> T newInstance(Class<T> c) throws SQLException {
    try {
        return c.newInstance();

    } catch (InstantiationException e) {
        throw new SQLException(
            "Cannot create " + c.getName() + ": " + e.getMessage());

    }