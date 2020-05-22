KieServices kieServices = KieServices.Factory.get();
    KieFileSystem kfs = kieServices.newKieFileSystem();
    FileInputStream fis = new FileInputStream( pathToSomeDrl );
    kfs.write( "src/main/resources/simple.drl",
                kieServices.getResources().newInputStreamResource( fis ) );
    KieBuilder kieBuilder = kieServices.newKieBuilder( kfs ).buildAll();
    Results results = kieBuilder.getResults();
    if( results.hasMessages( Message.Level.ERROR ) ){
        System.out.println( results.getMessages() );
        throw new IllegalStateException( "### errors ###" );
    }
    KieContainer kieContainer =
        kieServices.newKieContainer( kieServices.getRepository().getDefaultReleaseId() );
    KieBase kieBase = kieContainer.getKieBase();
    KieSession kieSession = kieContainer.newKieSession();