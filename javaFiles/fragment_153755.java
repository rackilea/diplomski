@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback=true)
public class YourTestClass {

    @Test
    @Transactional
    public void myTestMethod() {
        // db will get rolled back at the end of the test
    }
}