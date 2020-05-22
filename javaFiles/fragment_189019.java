val filesRDD = sc.textFile("/FileStore/tables/so.txt",5) 
val linesRDD = filesRDD.map(_.split(",")).filter(c => !"".equalsIgnoreCase(c(1).trim)).map(entries=> (entries(0),entries(1),entries(2),entries(3),entries(4),entries(5)))
val linesRDD2_first = linesRDD.map { case (v1, v2, v3, v4, v5, v6) => (v1, v3, v4, v5, v6) }
val linesRDD2_second = linesRDD.map { case (v1, v2, v3, v4, v5, v6) => (v2, v3, v4, v5, v6) }
val df1 = linesRDD2_first.toDF()
val df2 = linesRDD2_second.toDF()
val df3 = df1.union(df2).toDF("cardno", "age", "name", "address", "ssn")
df3.show(false)