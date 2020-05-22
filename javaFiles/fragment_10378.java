Dataset<Row> Ad1 = df.select(functions.col("Address1").as("Address4"));

        Dataset<Row> Ad2 = df.select("Address2");
        Dataset<Row> Ad3 = df.select("Address3");


        Dataset<Row> Union_DS = Ad1.union(Ad2).union(Ad3);

        Union_DS.show();


        Dataset<Row> Union_Sorted = Union_DS
        .groupBy("Address4")
        .agg(functions.count(functions.col("Address4")).as("Count"))

        .sort(functions.desc("Count"))

        ;
        Union_Sorted.show();