@Mock
private ApplicationService applicationService;

@Override
protected Application configure() {
    MockitoAnnotations.initMocks(this);
    ...
}