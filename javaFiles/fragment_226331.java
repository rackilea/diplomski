KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
kbuilder.add( ..., ResourceType.DRL);
if( kbuilder.hasErrors() ){
    System.err.println( "### compilation errors ###" );
    KnowledgeBuilderErrors errors = kbuilder.getErrors();
    for( KnowledgeBuilderError err: errors ){
        System.err.println( err.toString() );
    }
    throw new IllegalStateException( "compile errors" );
}
KnowledgeBase kbase = kbuilder.newKnowledgeBase();
StatelessKnowledgeSession ksession = kbase.newStatelessKnowledgeSession();