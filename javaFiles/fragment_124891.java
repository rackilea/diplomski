import java.lang.management.ManagementFactory;
import com.sun.management.ThreadMXBean;

public class Test {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = (ThreadMXBean)ManagementFactory.getThreadMXBean(); 
        long bytes = threadMXBean.getThreadAllocatedBytes(Thread.currentThread().getId());
        System.out.println(bytes);
    }
}