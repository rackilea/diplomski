public class Foo {

    public static void main(String[] argv) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Callable task =() ->  {
            System.out.print("input: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine();
        };
        Future future = executor.submit(task);
        try {
            String input = (String)future.get(10, TimeUnit.SECONDS);
            System.out.println(input);
        } catch (TimeoutException e) {
            future.cancel(true);
            System.out.println("Sorry you run out of time!");
        } catch (InterruptedException | ExecutionException e) {
            e.getMessage();
        } finally {
            executor.shutdownNow();
        }

    }
}