public class MockDAOPrototype {
    public DAO getMockWithDefaultBehaviour() {
        final DAO mockDAO = mock(DAO.class);
        when(mockDAO.a()).thenReturn("test");
        ...etc...

        return mockDAO;
    }
}