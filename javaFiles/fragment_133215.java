@Autowired
MyEntityRepository myEntityRepository;

@Test
@Rollback(false)
public void createAndThenDeleteRow() {
    MyEntity testRecord = new TestRecord( "fake", "data" );
    TestRecord savedRecord = myEntityRepository.save( testRecord );
    Long id = savedRecord.getId();
    TestRecord loadedRecord = myEntityRepository.findOne( id );
    assertNotNull( loadedRecord );
    myEntityRepository.delete( id );
    TestRecord reloadedRecord = myEntityRepository.findOne( id );
    assertNull( reloadedRecord );
}