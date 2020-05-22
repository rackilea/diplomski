@WebService(endpointInterface="org.jboss.test.schemavalidation.TestWS")
@InInterceptors(classes = {ValidationInterceptor.class})
public class TestWSImpl implements TestWS{

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

}