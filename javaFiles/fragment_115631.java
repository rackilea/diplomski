@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

@Mock
private AccountRepository accountRepository;

@Mock
private OperationRepository operationRepository;

@Mock
OperationConverter operationConverter;

@InjectMocks
private AccountServiceImpl accountService;

@Before
public void setUp() {
    /* here goes before-class init logic */
}

@Test
public void testMethod1() {
    /* here you test a method*/
}

@Test
public void testMethod2() {
    /* here you test another method*/
}
}