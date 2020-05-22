public class JmxUtils {

    public static MBeanServer getPlatformMbeanServer() {
        return ManagementFactory.getPlatformMBeanServer();
    }
}