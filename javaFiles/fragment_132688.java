public class Executor_Demo {
    public static void main(String... arg) throws ExecutionException, InterruptedException {
        int nThreads = 5100;
        ExecutorService executor = Executors.newFixedThreadPool(nThreads, new DaemonThreadFactory());

        List<Future<Results>> futures = new ArrayList<Future<Results>>();
        for (int i = 0; i < nThreads; i++) {
            futures.add(executor.submit(new BackgroundCallable()));
        }
        Results result = new Results();
        for (Future<Results> future : futures) {
            result.merge(future.get());
        }
        executor.shutdown();

        result.print(System.out);

    }

    static class Results {
        private long cpuTime;
        private long userTime;

        Results() {
            final ThreadMXBean tb = ManagementFactory.getThreadMXBean();
            cpuTime = tb.getCurrentThreadCpuTime();
            userTime = tb.getCurrentThreadUserTime();
        }


        public void merge(Results results) {
            cpuTime += results.cpuTime;
            userTime += results.userTime;
        }

        public void print(PrintStream out) {
            ThreadMXBean tb = ManagementFactory.getThreadMXBean();

            List<MemoryPoolMXBean> pools = ManagementFactory.getMemoryPoolMXBeans();
            for (int i = 0, poolsSize = pools.size(); i < poolsSize; i++) {
                MemoryPoolMXBean pool = pools.get(i);
                MemoryUsage peak = pool.getPeakUsage();
                out.format("Peak %s memory used:\t%,d%n", pool.getName(), peak.getUsed());
                out.format("Peak %s memory reserved:\t%,d%n", pool.getName(), peak.getCommitted());
            }

            out.println("Total thread CPU time\t" + cpuTime);
            out.println("Total thread user time\t" + userTime);
            out.println("Total started thread count\t" + tb.getTotalStartedThreadCount());
            out.println("Current Thread Count\t" + tb.getThreadCount());
            out.println("Peak Thread Count\t" + tb.getPeakThreadCount());
            out.println("Daemon Thread Count\t" + tb.getDaemonThreadCount());
        }
    }

    static class DaemonThreadFactory implements ThreadFactory {
        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        }
    }

    static class BackgroundCallable implements Callable<Results> {
        @Override
        public Results call() throws Exception {
            Thread.sleep(100);
            return new Results();
        }
    }
}