public class TestScriptTerminate {

    ScheduledExecutorService pool = Executors.newScheduledThreadPool(2);

    void script() {
        ScriptEngineManager scriptManager = new ScriptEngineManager();
        ScriptEngine js = scriptManager.getEngineByName("nashorn");
        try {
            System.out.println("Script starting.");
            js.eval("while (true) { if (java.lang.Thread.interrupted()) break; }");
            System.out.println("Script finished.");
        } catch (ScriptException ex) {
            ex.printStackTrace();
        }
    }

    void init() throws Exception {
        Future<?> scriptTask = pool.submit(this::script);
        pool.schedule(() -> {
            System.out.println("Canceling now...");
            scriptTask.cancel(true);
        }, 5, TimeUnit.SECONDS);
        pool.shutdown();
    }

    public static void main(String[] args) throws Exception {
        new TestScriptTerminate().init();
    }
}