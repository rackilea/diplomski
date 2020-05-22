package org.awesomespark.examples;

import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.function.PairFunction;
import org.apache.spark.sql.*;
import scala.Tuple2;

import java.util.Map;

public class StratifiedDatasets {
    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("Stratified Datasets")
                .getOrCreate();

        Dataset<Row> data = spark.read().format("libsvm").load("sample_libsvm_data.txt");

        JavaPairRDD<Double, Row> rdd = data.toJavaRDD().keyBy(x -> x.getDouble(0));
        Map<Double, Double> fractions = rdd.map(Tuple2::_1)
                .distinct()
                .mapToPair((PairFunction<Double, Double, Double>) (Double x) -> new Tuple2(x, 0.8))
                .collectAsMap();

        JavaRDD<Row> sampledRDD = rdd.sampleByKeyExact(false, fractions, 2L).values();
        Dataset<Row> sampledData = spark.createDataFrame(sampledRDD, data.schema());

        sampledData.show();
        sampledData.printSchema();
    }
}