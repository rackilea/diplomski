KieServices kieServices = KieServices.Factory.get();
KieFileSystem kfs = kieServices.newKieFileSystem();
FileInputStream fis = new FileInputStream( "simple/simple.drl" );
kfs.write( "src/main/resources/simple.drl", 
           kieServices.getResources().newInputStreamResource( fis ) );
KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
// check there have been no errors for rule setup
Results results = kieBuilder.getResults();
if( results.hasMessages( Message.Level.ERROR ) ){
    System.out.println( results.getMessages() );
    throw new IllegalStateException( "### errors ###" );
}
KieContainer kieContainer =
    kieServices.newKieContainer( kieBuilder.getKieModule().getReleaseId() );
KieSession kieSession = kieContainer.newKieSession();