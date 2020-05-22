@Component
@ExportMetricWriter
public class MyMetricWriter implements MetricWriter, Closeable {

  private static final Log logger = LogFactory.getLog(MyMetricWriter.class);


@Override
public void increment(Delta<?> delta) {
    // record increment to log
}

@Override
public void set(Metric<?> value) {
    // record set metric to log
}

@Override
public void reset(String name) {
    // Not implemented
}

@Override
public void close() {
    /// ...
     }
}