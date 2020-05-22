public class ProcessHandlerA extends ProcessHandler {

          public ProcessHandlerA() {
              super(3);//configure pool size properly w.r.to ProcessA requirements
          }

          public void postInit() {
              ProcessA processA = new ProcessA("processA", properties);
              super(processA);
          }

          public void shutdown() {
              super.shutdown();
          }
     }