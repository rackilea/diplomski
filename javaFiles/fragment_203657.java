@RunWith(MockitoJUnitRunner.class)
........

@Mock
private Handle handle;

@Mock
private UserDao userDao;

@Spy
private DBI dbi = new DBI(mock(ConnectionFactory.class));

@InjectMocks
private UserManager userManager;

@Before
public void setUpDbi() {
    Mockito.doReturn(handle)
            .when(dbi).open();
    Mockito.when(handle.attach(UserDao.class))
            .thenReturn(userDao);

    TransactionStatus status = Mockito.mock(TransactionStatus.class);

    Answer<Object> transactionalAnswer = invocation ->
            ((TransactionCallback) invocation.getArguments()[0])
                    .inTransaction(handle, status);

    Mockito.when(handle.inTransaction(any()))
            .thenAnswer(transactionalAnswer);
}