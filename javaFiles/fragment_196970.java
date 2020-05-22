Dataset<Row> set1RowDataset = set1Dataset
        .groupBy(keyDataset.col(joinColumn))
        .agg(collect_set(set1Dataset.col("record")).as("set1s"))
        .select(
                keyDataset.col("id"),
                col("set1"));