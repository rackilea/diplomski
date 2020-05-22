public final void configure() throws OperationNotSupportedException{
    from("xmpp://localhost:5222/?blablabla...")
        .filter().method(...)
        .process(...)
        .to("seda:sub");

    from("seda:sub?concurrentConsumers=10)
     .to("esper://session_X");
 }