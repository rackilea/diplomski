public class Tasks {
    public static void main(String[] args) throws InterruptedException {
        ExecutorCompletionService<String> service = new ExecutorCompletionService<String>(Executors.newSingleThreadExecutor());

        List<Callable<String>> callables = new ArrayList<>();
        Map<Future<String>, Callable<String>> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            final String name = Integer.toString(i);
            Callable<String> c = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return name;
                }

                @Override
                public String toString() {
                    return name;
                }
            };
            callables.add(c);

            Future<String> future = service.submit(c);
            map.put(future, c);
        }

        for (int i = 0; i < callables.size(); i++) {
            Future<String> future = service.take();
            Callable<String> correspondingTask = map.get(future);
            System.out.println("correspondingTask = " + correspondingTask);
        }
    }
}