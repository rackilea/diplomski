import org.apache.wicket.util.tester.WicketTester;
import org.junit.Before;
import org.junit.Test;

public class TestFormPage {
    private WicketTester tester;

    @Before
    public void setUp() {
        tester = new WicketTester(new WicketApplication());
    }

    @Test
    public void homepageRendersSuccessfully() {
        tester.startPage(FormPage.class);
        tester.assertRenderedPage(FormPage.class);

        tester.executeAjaxEvent("myForm", "submit");    
    }
}