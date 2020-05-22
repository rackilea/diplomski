public ConnectionManagementControllerImplTest() {
    super();

    connectionManagementBusinessServiceMocked = Mockito.mock(ConnectionManagementBusinessService.class);

    connectionManagementControllerMocked = new ConnectionManagementControllerImpl();
    connectionManagementControllerMocked.setConnectionManagementBusinessService(connectionManagementBusinessServiceMocked);

    setTestClass(ConnectionManagementControllerImpl.class, connectionManagementControllerMocked);
}