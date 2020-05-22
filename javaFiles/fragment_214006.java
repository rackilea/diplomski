package main;

import java.util.Properties;
import kafka.metrics.KafkaMetricsReporter;
import kafka.metrics.KafkaMetricsReporter$;
import kafka.utils.VerifiableProperties;
import scala.collection.*;

public class Reporters {

    public static void main(String[] args) {
        Properties props = new Properties();
        Seq<KafkaMetricsReporter> reporters = KafkaMetricsReporter$.MODULE$.startReporters(new VerifiableProperties(props));
    }
}