import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamMethods {

    public static void main(String[] args) {
        Stream<Supplier<double[]>> s = Stream.of(
            ParallelStreamMethods::methodA, 
            ParallelStreamMethods::methodB, 
            ParallelStreamMethods::methodC);

        List<double[]> result = 
            s.parallel().map(r -> r.get()).collect(Collectors.toList());

        doSomething(result.get(0), result.get(1), result.get(2));
    }

    private static double[] methodA() {
        return getValues("methodA");
    }

    private static double[] methodB() {
        return getValues("methodB");
    }

    private static double[] methodC() {
        return getValues("methodC");
    }

    private static double[] getValues(String name) {
        System.out.println("Enter "+name);
        try {
            int n = 1000 + (int)(Math.random() * 500);
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Exit "+name);
        return new double[1000];
    }

    private static void doSomething(double[] a, double[] b, double[] c) {
        System.out.println("Doing something with "+a+", "+b+", "+c);
    }
}