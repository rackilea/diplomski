KieServices kieServices = KieServices.Factory.get();
KieFileSystem kfs = kieServices.newKieFileSystem();

FileInputStream fis = new FileInputStream( "simple/simple2.drl" );
kfs.write( "src/main/resources/simple.drl",
           kieServices.getResources().newInputStreamResource( fis ) );
FileInputStream fis1 = new FileInputStream( "simple/simple.dsl" );
kfs.write( "src/main/resources/simple.dsl",
           kieServices.getResources().newInputStreamResource( fis1 ) );
FileInputStream fis2 = new FileInputStream( "simple/simple.dslr" );
kfs.write( "src/main/resources/simple.dslr",
           kieServices.getResources().newInputStreamResource( fis2 ) );

KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();

Results results = kieBuilder.getResults();
if( results.hasMessages( Message.Level.ERROR ) ){
    System.out.println( results.getMessages() );
        throw new IllegalStateException( "### errors ###" );
}

KieContainer kieContainer =
  kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );

KieBase kieBase = kieContainer.getKieBase();