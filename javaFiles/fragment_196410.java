import static org.apache.spark.sql.functions.*;

...

ds1.join(ds2, ds1.col("Compte").equalTo(ds2.col("Compte")), "full_outer")
                .select(ds1.col("Compte").alias("Compte1"),
                        ds2.col("Compte").alias("Compte2"),
                        ds1.col("Lib"),
                        ds1.col("ReportDebit"),
                        ds1.col("ReportCredit"),
                        ds2.col("SoldeBalance"))
                .withColumn("Compte", when(col("Compte1").isNull(), col("Compte2")).otherwise(col("Compte1")))
                .drop("Compte1", "Compte2")
                .na().fill(0.0, new String[] { "ReportDebit", "ReportCredit", "SoldeBalance" })
                .na().fill("", new String[] { "Lib" })
                .show();