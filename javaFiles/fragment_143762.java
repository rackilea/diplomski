private Test test;
private SomethingService somethingService;

@Autowired
public void setTest(Test test) {
    this.test = test;
}

@Autowired
public void setSomethingService(SomethingService somethingService) {
    this.somethingService = somethingService;
}