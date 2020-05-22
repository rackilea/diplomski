public static DistributionApproximation buildQuadraticApproximation(JdbcOperations jdbcTemplate, String table, String column) {
    int id_min = jdbcTemplate.queryForObject("SELECT MIN(" + column + ") from " + table + " WHERE " + column + " IS NOT NULL", Integer.class);
    int id_max = jdbcTemplate.queryForObject("SELECT MAX(" + column + ") from " + table + " WHERE " + column + " IS NOT NULL", Integer.class);
    Integer id_half = 0;

    try {
        id_half = jdbcTemplate.queryForObject("SELECT MAX(" + column + ") from " + table + " WHERE " + column + " IS NOT NULL " + " and " + column + " < " + Math.ceil((id_max - id_min) / 2.0), Integer.class); 
        if(id_half == null){
           id_half = (id_max - id_min) / 2;
        }
    }