import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Foo {
   // initialize all your lists first
   private ArrayList<Double> cPUUtilizationList = new ArrayList<>();
   private ArrayList<Double> diskReadOpsList = new ArrayList<>();
   private ArrayList<Double> diskWriteOpsList = new ArrayList<>();
   private ArrayList<Double> diskReadBytesList = new ArrayList<>();
   private ArrayList<Double> diskWriteBytesList = new ArrayList<>();
   private ArrayList<Double> networkInList = new ArrayList<>();
   private ArrayList<Double> networkOutList = new ArrayList<>();

   private Map<String, ArrayList<Double>> metricsListMap = new HashMap<String, ArrayList<Double>>();

   public Foo() {
      // insert into Map in constructor or method
      metricsListMap.put("CPUUtilization", cPUUtilizationList);
      metricsListMap.put("diskReadOps", diskReadOpsList);
      metricsListMap.put("diskWriteOps", diskWriteOpsList);
      metricsListMap.put("diskReadBytes", diskReadBytesList);
      metricsListMap.put("diskWriteBytes", diskWriteBytesList);
      metricsListMap.put("networkIn", networkInList);
      metricsListMap.put("networkOut", networkOutList);
   }
}