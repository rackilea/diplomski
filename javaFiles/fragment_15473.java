import org.junit.runner.RunWith;

import com.googlecode.junittoolbox.ParallelSuite;
import com.googlecode.junittoolbox.SuiteClasses;

@RunWith(ParallelSuite.class)
@SuiteClasses({"**/**.class",           //All classes
             enter code here  "!**/**Suite.class" })    //Excepts suites
public class AllTestsSuite {}