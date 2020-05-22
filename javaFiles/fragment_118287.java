private static void writeToSummaryV4(Dataset summary) {
    summary.write()
            .format("jdbc")
            .option("url", MYSQL_URL)
            .option("dbtable", MYSQL_DATABASE + "." + MYSQL_SUMMARY_TABLE)
            .option("user", MYSQL_USERNAME)
            .option("password", MYSQL_PASSWORD)
            .mode(SaveMode.Append)
            .save();
}