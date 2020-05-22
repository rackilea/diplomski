public static final String getPid() {
    try {
        RuntimeMXBean runtimeBean = ManagementFactory.getRuntimeMXBean();
        String name = runtimeBean.getName();
        int k = name.indexOf('@');
        if (k > 0)
            return name.substring(0, k);
    } catch (Exception ex) {
    }
    return null;
}