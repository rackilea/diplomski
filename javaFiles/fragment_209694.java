@RunWith(Suite.class)
    @SuiteClasses({ AllTests.class, AllTests.class, AllTests.class})
    public class MasterTest {  
        public static void main(String[] args) {
            Result result = JUnitCore.runClasses(AllTests.class);
                for (Failure failure : result.getFailures()) {
                    System.out.println(failure.toString());                
                }
        }
    }