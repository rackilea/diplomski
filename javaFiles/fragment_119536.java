private Logger log; //instantiate in a setter AKA dependency injection/inversion of control

public void systemUnderTest() {
    log.connectToDatabaseForAuditing();
    doLogicYouWantToTest();
}