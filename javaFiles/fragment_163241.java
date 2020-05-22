@RunWith(MyAnnotationRunner.class)
public class Tests {
    @Test
    public void testUsingNormalTestAnnotation() {
        Assert.fail();
    }

    @MyTest
    public void testUsingMyTestAnnotation() {
        Assert.fail();
    }
}