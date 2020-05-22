public class SomeTestClass {

   @Rule
   public JUnitRuleMockery context = new JUnitRuleMockery();

   private SomeOtherClass fullScreenFrame;

   @Before
   public void setUp() {
       fullScreenFrame = context.mock(SomeOtherClass.class);
   }
}