public static void main(String[] args) throws Exception {

    Main main = new Main();

    //the XML file has a CamelContext in it. 
    main.setApplicationContextUri("myRoutes.xml");
    main.start();//instantiates the CamelContext so we can use it in Java
    List<CamelContext> camelContexts = main.getCamelContexts(); //should only have 1 item in the list
    CamelContext context = camelContexts.get(0);

    //in order to add a component to the registry the following is needed for set up
    //  afterwards, should just be able to add anything to the registry with registry.put("name", object)
    final SimpleRegistry registry = new SimpleRegistry();
    final CompositeRegistry compositeRegistry = new CompositeRegistry();
    compositeRegistry.addRegistry(context.getRegistry());
    compositeRegistry.addRegistry(registry);
    ((DefaultCamelContext) context).setRegistry(compositeRegistry);

    final FileIdempotentRepository myFileStore = new FileIdempotentRepository();
    File myFile = new File("idempotentRepoFiles/myFileStore.txt");

    final TimeStampFileFilter<?> myFileFilter = new TimeStampFileFilter<Object>(0L);
    registry.put("myFileFilter", myFileFilter);

    //512MB
    myFileStore.setMaxFileStoreSize(536870912L);
    myFileStore.setFileStore(myFile);
    myFileStore.setCacheSize(100000);

    //add a route to the CamelContext that was initially created in the XML file
    context.addRoutes(new RouteBuilder() {

        @Override
        public void configure() throws Exception {
            onException(myException.class)
                .handled(true);
            onException(GenericFileOperationFailedException.class)
                .onException(SocketException.class)
                .maximumRedeliveries(2)
                .redeliveryDelay(5000L)
                ;
            Processor myProcessor = new myProcessor();
            from("{{myStart}}&filter=#myFileFilter")
            .setHeader("myFileRepoKey", simple("${file:name}-${file:modified}"))
            .idempotentConsumer(header("myFileRepoKey"), myFileStore)
            .process(myProcessor)
            .to("{{myEnd}}")
            ;

        }

    });

    context.start();
    main.run();
}