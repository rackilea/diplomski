/**
 * Converts a SQL statement containing exactly one IN clause to an IN clause
 * using multiple comma-delimited parameters.
 *
 * @param sql The SQL statement string with one IN clause.
 * @param params The number of parameters the SQL statement requires.
 * @return The SQL statement with (?) replaced with multiple parameter
 * placeholders.
 */
public static String any(String sql, final int params) {
    // Create a comma-delimited list based on the number of parameters.
    final StringBuilder sb = new StringBuilder(
            new String(new char[params]).replace("\0", "?,")
    );

    // Remove trailing comma.
    sb.setLength(Math.max(sb.length() - 1, 0));

    // For more than 1 parameter, replace the single parameter with
    // multiple parameter placeholders.
    if (sb.length() > 1) {
        sql = sql.replace("(?)", "(" + sb + ")");
    }

    // Return the modified comma-delimited list of parameters.
    return sql;
}