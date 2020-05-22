@RunWith(MockitoJUnitRunner.class)
public class WrapperUtilsTest {
    @Mock Class class1;
    @Mock Class class2;

    @Test public void ensure_that____whatever() {
        // given
        WrapperUtils tested_utils = new WrapperUtils(new WrapperClass(class1, class2));

        // when
        tested_utils.processClass();

        // then
        verify(class1).someInteraction();
        verify(class2).someInteraction();
    }
}