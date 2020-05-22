public class RetryAnalyzer implements IRetryAnalyzer  { 
private int count = 0; 
private int maxCount = 4; // set your count to re-run test

public boolean retry(ITestResult result) { 
        if(count < maxCount) {                     
                count++;                                    
                return true; 
        } 
        return false; 
}
}