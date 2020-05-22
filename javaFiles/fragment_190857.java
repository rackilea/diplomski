import java.text.SimpleDateFormat;
import java.util.Date;

    public class Log {

        public static final int LEVEL_INFO = 0;
        public static final int LEVEL_WARNING = 1;
        public static final int LEVEL_ERROR = 2;

        private static final ThreadLocal<SimpleDateFormat> formatter = ThreadLocal.withInitial(() -> new SimpleDateFormat("HH:mm:ss"));

        /**
         * Used instead of System.out.println for consistent formatting.
         *
         * @param messageToPrefix Message that you want to send to print.
         * @param errorLevel Type of message you want to send.
         */
        public static void print(String messageToPrefix, int errorLevel) {
            StringBuilder message = new StringBuilder();
            message.append("[").append(formatter.get().format(new Date())).append("] ");
            switch(errorLevel) {
                case LEVEL_INFO:
                    message.append("[Info] ");
                    break;
                case LEVEL_WARNING:
                    message.append("[Warning] ");
                    break;
                case LEVEL_ERROR:
                    message.append("[Error] ");
                    break;
            }
            message.append(messageToPrefix);
            System.out.println(message.toString());
        }
    }