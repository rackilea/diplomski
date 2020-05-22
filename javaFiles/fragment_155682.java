String sql = "SELECT count(*) from useraudit where USERID=? AND ENDDATETIME is null";
boolean result = false;

int count = getJdbcTemplate().queryForObject(
                    sql, new Object[] { userId }, Integer.class);

if (count > 0) {
    result = true;
}

return result;