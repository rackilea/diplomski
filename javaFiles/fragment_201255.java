public class MemUsage {

    public static void main(String[] args) {
        Instrumentation instr = InstrumentationAgent.getInstrumentation();
        if (instr == null) {
            System.err.println("No Instrumentation, use the VM option \"-javaagent:Instrumentation.jar\"");
            return;
        }
        System.out.println();
        System.out.println("an implementation-specific approximation of the amount of storage");
        System.out.println("Calendar = " + instr.getObjectSize(Calendar.getInstance()));
        System.out.println();
    }
}