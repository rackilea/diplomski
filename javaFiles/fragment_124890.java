import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;

import java.lang.management.ThreadMXBean;

public class Test {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean(); 
        try { 
            Method getBytes = threadMXBean.getClass().getMethod("getThreadAllocatedBytes", long.class); 
            getBytes.setAccessible(true); 

            long threadId = Thread.currentThread().getId();
            long bytes = (long)getBytes.invoke(threadMXBean, threadId);
            System.out.println(bytes);
        } catch (Throwable e) { 
            System.out.println(e);
        }
    }
}