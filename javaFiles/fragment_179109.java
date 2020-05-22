@Autowired
private DummyService _dummyService;

@Test(expected = ApplicationSecurityException.class)
public void adminOnlyFails() throws ApplicationSecurityException {

    _dummyService.adminOnly();
}