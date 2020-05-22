import java.lang.management.ManagementFactory;

import javax.management.ObjectName;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;

public class HotSpotTest {

    public static void main(String [] args) throws Exception {
        printHotSpotOption("MaxHeapFreeRatio");
        printHotSpotOption("SurvivorRatio");
        printHotSpotOptions();
    }

    private static void printHotSpotOption(String option) throws Exception {
        ObjectName name = new ObjectName("com.sun.management:type=HotSpotDiagnostic");
        String operationName = "getVMOption";
        Object [] params = new Object [] {option};
        String [] signature = new String[] {String.class.getName()};
        Object result = ManagementFactory.getPlatformMBeanServer().invoke(name, operationName, params, signature);
        CompositeDataSupport data = (CompositeDataSupport) result;

        System.out.println(option);
        System.out.println("- Value: "+data.get("value"));
        System.out.println("- Origin: "+data.get("origin"));
    }

    private static void printHotSpotOptions() throws Exception {
        ObjectName name = new ObjectName("com.sun.management:type=HotSpotDiagnostic");
        String attributeName = "DiagnosticOptions";
        Object result = ManagementFactory.getPlatformMBeanServer().getAttribute(name, attributeName);
        CompositeData [] array = (CompositeData[]) result;
        for (CompositeData d : array) {
            System.out.println(d.get("name"));
            System.out.println("- Value: "+d.get("value"));
            System.out.println("- Origin: "+d.get("origin"));
        }
    }
}