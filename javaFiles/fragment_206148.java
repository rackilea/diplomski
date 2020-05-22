import org.testng.Assert;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Listeners(IdentifyRetriedTests.IdentifyingListener.class)
public class IdentifyRetriedTests {
    private static AtomicInteger counter = new AtomicInteger(0);
    private static AtomicInteger anotherCounter = new AtomicInteger(0);

    @Test(retryAnalyzer = Retry.class)
    public void hello() {
        if (counter.incrementAndGet() == 3) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Test(retryAnalyzer = Retry.class)
    public void anotherHello() {
        if (anotherCounter.incrementAndGet() == 5) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

    }

    public static class IdentifyingListener extends TestListenerAdapter {

        @Override
        public void onTestSuccess(ITestResult tr) {
            IRetryAnalyzer retry = tr.getMethod().getRetryAnalyzer();
            if (retry instanceof Retry) {
                //Check if the retry analyser's retry count was greater than zero. If yes, then its a retried method
                if (((Retry) retry).getRetryCount() > 0) {
                    tr.setAttribute("retried", true);
                }
            }
        }

        @Override
        public void onFinish(ITestContext testContext) {
            Set<ITestResult> results = new HashSet<>();
            results.addAll(testContext.getFailedTests().getAllResults());
            results.addAll(testContext.getPassedTests().getAllResults());
            for (ITestResult result : results) {
                if (result.getAttribute("retried") != null) {
                    System.err.println(result.getMethod().getMethodName() + "() was retried");
                }
            }
        }
    }

    public static class Retry implements IRetryAnalyzer {
        private AtomicInteger retryCount = new AtomicInteger(0);
        private static int maxRetryCount = 10;

        public boolean retry(ITestResult result) {
            return retryCount.getAndIncrement() < maxRetryCount;
        }

        int getRetryCount() {
            return retryCount.get();
        }
    }
}