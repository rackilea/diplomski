public class MyTests {

        @Rule 
        public MyTestRule myProjectTestRule = new MyTestRule();

        @Test
        @MyTestCondition(condition=Condition.COND1)
        public void testMethod1() {
                //testMethod1 code here
        }

        @Test
        @MyTestCondition(condition=Condition.COND2)
        public void testMethod2() {
                //this test will NOT get executed as COND1 defined in Rule
                //testMethod2 code here
        }

}