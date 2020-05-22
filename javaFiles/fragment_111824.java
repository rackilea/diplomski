public class InstrumentationAgent { //create a **InstrumentationAgent** class

      private static Instrumentation instrumentation;

      public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
      }

      public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
      }
    }