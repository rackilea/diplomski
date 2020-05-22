public final void configure() throws OperationNotSupportedException{
    from("xmpp://localhost:5222/?blablabla...")
        .filter().method(...)
        .process(...)
        .threads()
        .executorService(Executors.newFixedThreadPool(2))
        .to("esper://session_X");
 }