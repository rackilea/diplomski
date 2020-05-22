@Mock
YourDaoThing mock;

@Before
public setUp(){
  MockitoAnnotation.initMocks(this);
  service = new Service();
  service.setDao(mock);
}

@Test
public testGetSubject(){
  String someString = "whatever";
  when(mock.getSubjectOracle(id,country)).thenReturn(someString)

  assertEquals(expect, service.callToTheMethodYouTest())

}