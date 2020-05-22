ScheduledExecutorService schedulerExecutor = Executors.newScheduledThreadPool(2);
Callable<Process> callable = new Callable<Process>() {

    @Override
    public Process call() throws Exception {
        Process p = Runtime.getRuntime().exec("cmd /c start /b java -jar D:\\MovieLibrary.jar");
        return p;
    }
};
FutureTask<Process> futureTask = new FutureTask<Process>(callable);
schedulerExecutor.submit(futureTask);           

System.exit(0);