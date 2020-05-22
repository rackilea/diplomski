@BeforeClass
public void setUp() throws Exception {

    BrowserFactory b = new BrowserFactory();
driver =b.startBrowser("http://10.5.9.45/BKOMais_S86825EstrategiaBackOfficeClaroFixo/");

}

@Test
public void logarSistema(){

    LogarSistemaPage s = new LogarSistemaPage();
    s.logarSistema(driver);

}