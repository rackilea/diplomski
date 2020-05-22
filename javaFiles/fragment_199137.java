@RunWith(MockitoJUnitRunner.class)
public class MyClassTest() {
    @InjectMocks
    private MyClass myClass;

    @Mock
    private OtherClass1 mockedClass1UsedByMyClass;

    @Spy
    private HelperClass helperClass;

    @Mock
    private OtherClass2 mockedClass2UsedByMyClass;
}