...
private DAO mockDAO;

@Before 
public void setUp() {
    mockDAO = mock(DAO.class);
    when(mockDAO.a()).thenReturn("test");
    ...etc...
}    
...