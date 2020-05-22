@Mock
SftpSession sftpSession;

@Mock
DefaultSftpSessionFactory sessionFactory;

@Captor
ArgumentCaptor<InputStream> captor;

private SFTPServiceImpl sftpServiceImpl;

@BeforeEach
public void init() {
    MockitoAnnotations.initMocks(this);
    sftpServiceImpl = new SFTPServiceImpl(sessionFactory);
}

@Test
void addFile() throws Exception {
    byte[] bytes = {69, 121, 101, 45, 62, 118, 101, 114, (byte) 196, (byte) 195, 61, 101, 98};

    given(sessionFactory.getSession()).willReturn(sftpSession);
    given(sftpSession.exists(anyString())).willReturn(false);

    String directory = "testDirectory";
    String fileName = "testFileName";

    sftpServiceImpl.addFile(directory, fileName, bytes);

    verify(sftpSession, times(1)).write(captor.capture(), eq(directory + "/" + fileName));

    // you need to compare the byte arrays here
    assertArrayEquals(bytes, captor.getValue());
}