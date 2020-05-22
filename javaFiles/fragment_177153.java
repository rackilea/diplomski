import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.spi.Configurator;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;

public class Log4jAlternativeConfig {

    private static class PrintStreamCallbackSupportDecorator extends PrintStream {

        public PrintStreamCallbackSupportDecorator(OutputStream out, Callback callback) {
            super(out);
            this.callback = callback;
        }

        public interface Callback {
            public void onPrintln(String x);
        }

        private Callback callback;

        @Override
        public void println(String x) {
            callback.onPrintln(x);
            super.println(x);
        }
    }

    public static void main(String[] args) {

        PrintStreamCallbackSupportDecorator.Callback callback = new PrintStreamCallbackSupportDecorator.Callback() {
            @Override
            public void onPrintln(String x) {
                if (x.startsWith("log4j:WARN No appenders could be found for logger")) {
                    Configurator configurator = new PropertyConfigurator();
                    URL url = Loader.getResource("log4j_alternative.properties");
                    configurator.doConfigure(url, LogManager.getLoggerRepository());
                }
            }
        };

        System.setErr(new PrintStreamCallbackSupportDecorator(System.err, callback));

        Logger log = LogManager.getLogger(Log4jAlternativeConfig.class);

        //causes "No appenders could be found for logger" warning
        log.error("test");

        //should be logged as configured in log4j_alternative.properties
        log.error("test 2");
    }
}