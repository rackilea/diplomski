Dataset<Row> ds = spark.sql("select 'word1 word2' as document1, 'word2 word3' as document2");
ds.show();

Dataset<Row> ds1 = ds.select(functions.explode(functions.split(ds.col("document1"), " ")).as("word"));
Dataset<Row> ds2 = ds.select(functions.explode(functions.split(ds.col("document2"), " ")).as("word"));      

Dataset<Row> intersection = ds1.join(ds2, ds1.col("word").equalTo(ds2.col("word"))).select(ds1.col("word").as("Common words"));
intersection.show();