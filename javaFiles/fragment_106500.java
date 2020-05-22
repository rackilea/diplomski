public static void agentmain(String args, Instrumentation instr) throws Exception {
    Class normalClass = Class.forName("Normal");
    Field myStrField = normalClass.getDeclaredField("myStr");
    myStrField.setAccessible(true);
    myStrField.set(null, "Working!");
}