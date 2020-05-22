import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;
import org.apache.spark.sql.api.java.UDF2;
import org.apache.spark.sql.expressions.UserDefinedFunction;
import org.apache.spark.sql.types.DataTypes;

public class StackOverflowUDF {
    public static void main(String args[]) {
        SparkSession spark = SparkSession.builder().appName("JavaWordCount").master("local").getOrCreate();

        Dataset<Row> ds = spark.sql("select 'word1 word2' as document1, 'word2 word3' as document2");
        ds.show();

        UDF2<String, String, String> intersection = new UDF2<String, String, String>() {
            @Override
            public String call(String arg, String arg2) throws Exception {
                String key = inter(arg, arg2);
                return key;
            }

            private String inter(String arg1, String arg2) {
                List<String> list1 = Arrays.asList(arg1.split(" "));
                return Stream.of(arg2.split(" ")).filter(list1::contains).collect(Collectors.joining(" "));
            }
        };

        UserDefinedFunction intersect = functions.udf(intersection, DataTypes.StringType);

        Dataset<Row> ds1 = ds.select(ds.col("document1"), ds.col("document2"),
                intersect.apply(ds.col("document1"), ds.col("document2")));
        ds1.show();
        ds1.printSchema();

        ds.createOrReplaceTempView("v_table");

        spark.sqlContext().udf().register("intersect", intersection, DataTypes.StringType);
        Dataset<Row> df = spark
                .sql("select document1, document2, " + "intersect(document1, document2) as RowKey1" + " from v_table");
        df.show();
        spark.stop();

    }
}