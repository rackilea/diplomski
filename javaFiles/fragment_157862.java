public class A implements Serializable {
    private int x;
    public A() {}
    public A(int x) {this.x = x;}
    // getters and setters
}

// later in main class
import java.util.Arrays;
// later
JavaRDD<A> rdd = javaSparkContext.parallelize(Arrays.asList(new A(5)));