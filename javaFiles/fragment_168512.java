public class HeapGenerator {

private HeapGenerator() {

}

private static final String HOTSPOT_BEAN_NAME = "com.sun.management:type=HotSpotDiagnostic";
private static long lastHeapDumpGenrationTime ;
// field to store the hotspot diagnostic MBean
private static volatile HotSpotDiagnosticMXBean hotspotMBean;

public static void generateHeapDump(String fileName, boolean live) {
    // initialize hotspot diagnostic MBean
    initHotspotMBean();
    try {
        File dumpFile = new File(fileName);
        if (dumpFile.exists()) {
            dumpFile.delete();
        }
        hotspotMBean.dumpHeap(fileName, live);
    } catch (RuntimeException re) {
        throw re;
    } catch (Exception exp) {
        throw new RuntimeException(exp);
    }
}

// initialize the hotspot diagnostic MBean field
private static void initHotspotMBean() {
    if (hotspotMBean == null) {
        synchronized (HeapDumpGenerator.class) {
            if (hotspotMBean == null) {
                hotspotMBean = getHotspotMBean();
            }
        }
    }
}

// get the hotspot diagnostic MBean from the
// platform MBean server
private static HotSpotDiagnosticMXBean getHotspotMBean() {
    try {
        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        HotSpotDiagnosticMXBean bean = ManagementFactory.newPlatformMXBeanProxy(server, HOTSPOT_BEAN_NAME, HotSpotDiagnosticMXBean.class);
        return bean;
    } catch (RuntimeException re) {
        throw re;
    } catch (Exception exp) {
        throw new RuntimeException(exp);
    }
}

public static String generateHeapDump() {
    String fileName = getFullHeapDumpFileName();
    generateHeapDump(fileName, true);
    return fileName;
}

}