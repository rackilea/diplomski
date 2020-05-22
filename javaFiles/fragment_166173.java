@Mock
private HibernateSession hibernateSession;

@Before
public void setUp() {
    when(sessionFactory.getCurrentSession()).thenReturn(hibernateSession);

    campaignModel = DraftTestHelper.buildDraftModel();
    if(sessionFactory == null) {
        System.out.println("Session Factory is null");
    }
    else {
        System.out.println("Session Factory is not null");
        session = sessionFactory.getCurrentSession();

        if(session != null) {
            System.out.print("Session is not null");
        }
        else {
            System.out.println("Session is null");
        }
    }
}