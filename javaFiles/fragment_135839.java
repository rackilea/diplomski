import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class ThingOneTest {

    Mockery context = new Mockery();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {
        ThingOneI thingOne = context.mock(ThingOneI.class);
        Map<String, String> methMap = new HashMap<String, String>();
        methMap.put("getData", "5");

        context.checking(new Expectations() {{

            for (Map.Entry<String, String> entry : methMap.entrySet())
                allowing(any(ThingOneI.class))
                    .method(entry.getKey())
                    .with(any(String.class));
                    will(returnValue(entry.getValue()));
            }

         }});

         System.out.println(thingOne.getData());

    }
}