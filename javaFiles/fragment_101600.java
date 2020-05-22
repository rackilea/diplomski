private static class ParameterizedQuery {
    final String sql;
    final Parameter[] params;

    ParameterizedQuery(String sql, Parameter[] params) {
        this.sql = sql;
        this.params = params.clone();
    }
}

private static class Parameter {
    final int position;
    final String value;

    Parameter(int position, String value) {
        this.position = position;
        this.value = value;
    }
}