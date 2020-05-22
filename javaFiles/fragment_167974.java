public class TestcaseSearch extends Loginclass {
    @BeforeTest
    public final void Startup() throws MalformedURLException {
        GetDriver();        
    }       

    @Test
    public void fieldsSearch(String username, String password)
            throws Exception {      
        navigateToLogin();
    }
}