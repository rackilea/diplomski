Dataset<Row> csvLoad = sparkSession.read().format("csv")
        .option("delimiter", ";")
        .schema(sch)
        .option("header","false")
        .option("dateFormat", "m/d/YYYY")
        .load(somefilePath);