DaoA dao;
DaoB otherDao;

@Before
public void setupTests() throws IOException {
    super.setupTests();
    dao = dbi.onDemand(DaoA.class);
    otherDao = dbi.onDemand(DaoB.class);
}