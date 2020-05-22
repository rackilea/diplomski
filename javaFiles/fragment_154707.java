Dataset<Row> dataset = spark.read().jdbc(RPP_CONNECTION_URL, fake, rppDBProperties);
        dataset = dataset.union(spark.read().jdbc(RPP_CONNECTION_URL, creditoDia3, rppDBProperties).cache());
        dataset = dataset.union(spark.read().jdbc(RPP_CONNECTION_URL, creditoDia2, rppDBProperties).cache());
        dataset = dataset.union(spark.read().jdbc(RPP_CONNECTION_URL, creditoDia, rppDBProperties).cache());
        dataset = dataset.union(spark.read().jdbc(RPP_CONNECTION_URL, debitoDia3, rppDBProperties).cache());
        dataset = dataset.union(spark.read().jdbc(RPP_CONNECTION_URL, debitoDia2, rppDBProperties).cache());
        dataset = dataset.union(spark.read().jdbc(RPP_CONNECTION_URL, debitoDia,rppDBProperties).cache());
        dataset = dataset.cache();