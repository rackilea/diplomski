KieHelper kieHelper = new KieHelper();         
kieHelper.addResource(ResourceFactory.newInputStreamResource(new FileInputStream( "simple/simple.drl" )), ResourceType.DRL);

Results results = kieHelper.verify();
if( results.hasMessages( Message.Level.ERROR ) ){
    System.out.println( results.getMessages() );
    throw new IllegalStateException( "### errors ###" );
}

StatelessKieSession kieSession = kieHelper.build().newStatelessKieSession();