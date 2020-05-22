import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SquareCalculator {

    private ExecutorService ex = Executors.newSingleThreadExecutor();

    public void display(int i) {
        // TODO Auto-generated method stub
        System.out.println(i);
    }

    public Integer calculate(Integer inp) {
        Integer result;
        try {
            System.out.println("Before sending request");
            Future<Integer> res = ex.submit(() -> {
                Thread.sleep(5000);
                return inp * inp;
            });
            System.out.println("Request sent to caluclate and waiting for the result");
            result = res.get();
            ex.shutdown();
            return result;
        } catch (Exception e) {
            System.out.println("calculation was interrupted");
            return null;
        }
        //return ex.submit(()->squareing(inp));

    }

    public static void main(String[] args) throws InterruptedException, 
        ExecutionException {
        // TODO Auto-generated method stub
        try {
            SquareCalculator sqC = new SquareCalculator();
            sqC.display(1);
            Integer result = sqC.calculate(5);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Calclulation was interrupted");
        }
    }
}