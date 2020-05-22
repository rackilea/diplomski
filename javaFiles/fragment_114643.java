import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;

import java.util.List;

public void runtimeParameters() {
  RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
  List<String> aList = bean.getInputArguments();

  for (int i = 0; i < aList.size(); i++) {
    System.out.println( aList.get( i ) );
  }
}