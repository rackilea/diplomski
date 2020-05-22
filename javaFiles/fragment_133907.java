import org.junit.Before;
import org.junit.Test;
import java.util.Locale;

public class SchedulerModelTest {
@Before
public void setup() throws Exception {
    new WicketTester(new ReconAdminApplication());
    Session.get().setLocale(new Locale("en_us")); //always set the locale.
}

@Test
public test(){
   Information information = new Information();
   assertEquals("Foo is Foo", "Foo", information.getInfo() );
}

}