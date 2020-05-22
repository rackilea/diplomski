@RunWith(MockitoJUnitRunner.class)
public class WrapperUtilsTest {
    @Mock Class class1;
    @Mock Class class2;
    @Mock Supplier<WrapperClass> wrapped_class_supplier;

    @Test public void ensure_that____whatever() {
        // given
        BDDMockito.given(wrapped_class_supplier.get()).willReturn(new WrapperClass(class1, class2));
        WrapperUtils tested_utils = new WrapperUtils(wrapped_class_supplier);

        // when
        tested_utils.processClass();

        // then
        verify(class1).someInteraction();
        verify(class2).someInteraction();
    }
}