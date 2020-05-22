import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.io.ImmutableBytesWritable;
import org.apache.hadoop.hbase.mapreduce.TableInputFormat;
import org.apache.hadoop.hbase.util.Bytes;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.Function;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.SQLContext;
import scala.Tuple2;
import java.util.Arrays;

public class SparkHbaseHive {
    public static void main(String[] args) {
        Configuration conf = HBaseConfiguration.create();
        conf.set(TableInputFormat.INPUT_TABLE, "test");
        JavaSparkContext jsc = new JavaSparkContext(new SparkConf().setAppName("Spark-Hbase").setMaster("local[3]"));
        JavaPairRDD<ImmutableBytesWritable, Result> source = jsc
                .newAPIHadoopRDD(conf, TableInputFormat.class,
                        ImmutableBytesWritable.class, Result.class);
        SQLContext sqlContext = new SQLContext(jsc);
        JavaRDD<Table1Bean> rowJavaRDD = 

source.map((Function<Tuple2<ImmutableBytesWritable, Result>, Table1Bean>) object -> {
            Table1Bean table1Bean = new Table1Bean();
            table1Bean.setRowKey(Bytes.toString(object._1().get()));


table1Bean.setColumn1(Bytes.toString(object._2().getValue(Bytes.toBytes("colfam1"), Bytes.toBytes("col1"))));
            return table1Bean;
    });
        DataFrame df = sqlContext.createDataFrame(rowJavaRDD, Table1Bean.class);

        //similarly create df2
        //use df.join() and then register as joinedtable or register two tables and join
        //execute sql queries

        //Example of sql query on df
        df.registerTempTable("table1");
        Arrays.stream(sqlContext.sql("select * from table1").collect()).forEach(row -> System.out.println(row.getString(0) + "," + row.getString(1)));

    }
}
public class Table1Bean {
    private String rowKey;
    private String column1;


    public String getRowKey() {
        return rowKey;
    }

    public void setRowKey(String rowKey) {
        this.rowKey = rowKey;
    }

    public String getColumn1() {
        return column1;
    }

    public void setColumn1(String column1) {
        this.column1 = column1;
    }
}