import org.junit.*;
import org.junit.rules.ErrorCollector;
import org.hamcrest.CoreMatchers;

public class CheckVal {

public ErrorCollector collector = null;

public CheckVal(ErrorCollector collector) {
    this.collector = collector;
}

public void checkTable(String value) {

    String checkMe;

    checkMe = "1234";

    System.out.println("value coming in : " + value);
    System.out.println("value to check  : " + checkMe);
    collector.checkThat("Check values match", value, CoreMatchers.is(checkMe));

}