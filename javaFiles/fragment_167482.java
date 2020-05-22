long userId = 1;
int keepXLogsOfOthers = 1;
String del = "DELETE FROM log" +
                " WHERE user_id != " + userId +
                "  AND log._id NOT IN (" +
                "    SELECT _id" +
                "    FROM (" +
                "      SELECT _id" +
                "      FROM log" +
                "      WHERE user_id != " + userId +
                "      ORDER BY timestamp DESC" +
                "      LIMIT " + keepXLogsOfOthers +
                "    ) logs_of_others_to_keep" +
                ");";
db.execSql(del);