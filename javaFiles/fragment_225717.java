public static boolean isStartedWithJProfiler() {
    RuntimeMXBean runtimeMxBean = ManagementFactory.getRuntimeMXBean();
    List<String> arguments = runtimeMxBean.getInputArguments();
    for( String argument : arguments ) {
        if( argument.contains("profilerti") ) {
            return true;
        }
    }
    return false;
}