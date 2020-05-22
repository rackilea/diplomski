import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import a.sub.package.AnotherSuiteTest.class;

@RunWith(Suite.class)
@Suite.SuiteClasses({
   PackageLocalTestClass1.class,
   PackageLocalTestClass2.class,
   AnotherSuiteTest.class
})
public class JunitTestSuite {   
}