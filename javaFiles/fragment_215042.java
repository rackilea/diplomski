package example.flink;

import org.apache.flink.api.common.typeinfo.Types;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.table.api.java.StreamTableEnvironment;
import org.apache.flink.table.api.Table;
import org.apache.flink.table.api.TableEnvironment;
import org.apache.flink.table.sources.CsvTableSource;
import org.apache.flink.types.Row;

public class TestFlink {
    public static void main(String[] args) {

        final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        StreamTableEnvironment tEnv = TableEnvironment.getTableEnvironment (env);

        CsvTableSource csvTableSource = CsvTableSource
                .builder()
                .path("container_data.csv")
                .field("%CPU", Types.FLOAT)
                .field("MEM", Types.FLOAT)
                .field("VSZ", Types.FLOAT)
                .field("RSS", Types.FLOAT)
                .field("timestamp", Types.FLOAT)
                .field("OOM_Score", Types.FLOAT)
                .field("io_read_count", Types.FLOAT)
                .field("io_write_count", Types.FLOAT)
                .field("io_read_bytes", Types.FLOAT)
                .field("io_write_bytes", Types.FLOAT)
                .field("io_read_chars", Types.FLOAT)
                .field("io_write_chars", Types.FLOAT)
                .field("num_fds", Types.FLOAT)
                .field("num_ctx_switches_voluntary", Types.FLOAT)
                .field("num_ctx_switches_involuntary", Types.FLOAT)
                .field("mem_rss", Types.FLOAT)
                .field("mem_vms", Types.FLOAT)
                .field("mem_shared", Types.FLOAT)
                .field("mem_text", Types.FLOAT)
                .field("mem_lib", Types.FLOAT)
                .field("mem_data", Types.FLOAT)
                .field("mem_dirty", Types.FLOAT)
                .field("mem_uss", Types.FLOAT)
                .field("mem_pss", Types.FLOAT)
                .field("mem_swap", Types.FLOAT)
                .field("num_threads", Types.FLOAT)
                .field("cpu_time_user", Types.FLOAT)
                .field("cpu_time_system", Types.FLOAT)
                .field("cpu_time_children_user", Types.FLOAT)
                .field("cpu_time_children_system", Types.FLOAT)
                .field("container_nr_sleeping", Types.FLOAT)
                .field("container_nr_running", Types.FLOAT)
                .field("container_nr_stopped", Types.FLOAT)
                .field("container_nr_uninterruptible", Types.FLOAT)
                .field("container_nr_iowait", Types.FLOAT)
                .fieldDelimiter(",")
                .lineDelimiter("\n")
                .ignoreFirstLine()
                .ignoreParseErrors()
                .commentPrefix("%")
                .build();
        // name your table source
        tEnv.registerTableSource("container", csvTableSource);
        Table table = tEnv.scan("container");
        DataStream<Row> stream = tEnv.toAppendStream(table, Row.class);
        // define the sink as common print on console here
        stream.print();
        try {
            env.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}