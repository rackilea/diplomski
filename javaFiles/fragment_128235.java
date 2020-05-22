import com.google.common.collect.Maps;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.time.StopWatch;
import org.elasticsearch.common.collect.Lists;

public class TestPojo {

    private String name;
    private List<String> reportees;
    private String[] department;
    private Machine owns;
    private List<Machine> supplimentary;
    private int i = 10;
    private Map<String, Machine> machineList = Maps.newConcurrentMap();

    public static void main(String arg[]) {
        TestPojo aTestPojo = new TestPojo();
        aTestPojo.department = new String[] { "retail", "banking", "finance"};
        aTestPojo.reportees = new ArrayList<String>() {
            {
                add("1");
                add("2");
                add("3");
            }
        };

        Machine aMachine = new Machine("Train", "travel");
        Machine aMachine1 = new Machine("Lorry", "Carrier");
        aTestPojo.supplimentary = Lists.newArrayList(aMachine, aMachine1);
        aTestPojo.machineList.put("Train", aMachine);
        aTestPojo.machineList.put("Lorry", aMachine1);

        System.out.print(aTestPojo);
    }

    public static class Machine {
          private String machineName;
          private String duties;

        public Machine(String machineName, String duties) {
            super();
            this.machineName = machineName;
            this.duties = duties;
        }
        public String getMachineName() {
          return machineName;
        }
        public void setMachineName(String machineName) {
          this.machineName = machineName;
        }

      public String getDuties() {
          return duties;
      }

      public void setDuties(String duties) {
          this.duties = duties;
      }

    @Override
    public String toString() {
        JsonToStringBuilder builder = new JsonToStringBuilder(this);
        builder.append("machineName", machineName);
        builder.append("duties", duties);
        return builder.build();
    }
}

@Override
public String toString() {
    JsonToStringBuilder builder = new JsonToStringBuilder(this);
    builder.append("name", name);
    builder.append("reportees", reportees);
    builder.append("department", department);
    builder.append("owns", owns);
    builder.append("supplimentary", supplimentary);
    builder.append("i", i);
    builder.append("machineList", machineList);
    String value = builder.build();
    return value;
    }
}