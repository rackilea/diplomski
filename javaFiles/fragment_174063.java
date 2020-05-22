import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncExample { 
    String input; // common data

    // async method
    public String toLower() {
        return input.toLowerCase();
    }

    // method on main thread
    public void run() {
        input = "INPUT"; // set common data
        try {
            // start  async method
            CompletableFuture<String> future = CompletableFuture.supplyAsync(this::toLower);
            // here we can work in parallel
            String result = future.get(); // get the async result
            System.out.println("input="+input+"; result="+result);
        } catch (InterruptedException | ExecutionException e) {
        }
    }

    public static void main(String[] args) {
        new AsyncExample().run();
    }
}