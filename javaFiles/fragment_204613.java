public class Main {
    public static void main(final String[] args) {
        final RuntimeMXBean memMXBean = ManagementFactory.getRuntimeMXBean();
        final String prefix = "-XX:MaxPermSize=";
        final List<String> jvmArgs = memMXBean.getInputArguments();
        String maxPermSize = null;
        for (final String jvmArg : jvmArgs) {
            if (jvmArg.startsWith(prefix)) {
                maxPermSize = jvmArg.substring(prefix.length());
                break;
            }
        }

        System.out.println("MaxPermSize is " + maxPermSize);
    }
}