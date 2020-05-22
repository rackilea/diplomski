@Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockStatic(StatusEnum.class);       
    }

    @Test
    public void test_findAllEmployeesPaginated() {
        Pageable pageable = PageRequest.of(0, 8);

        mockStatic(Utils.class);
        when(Utils.sort(any(Pageable.class), anyInt(), anyInt(), anyString(), anyString())).thenReturn(pageableMock);
        when(employeeRepositoryMock.findByStatus(StatusEnum.A, pageableMock)).thenReturn(employeePage);
    }