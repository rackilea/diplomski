/*
    When I try to just put my factory here, I am getting
        AssertionError: duplicate context value
    but I can remove base factory by passing null
     */
    context.put(parserFactoryKey, (ParserFactory) null);
    MyParserFactory factory = new MyParserFactory(context);
    context.put(parserFactoryKey, factory);
    /*
    Now context contains my implementation of ParserFactory, but I
    also need to inject it into JavaCompiler which is the only object
    (FOR MY JDK: check your compiler behavior carefully with debugger)
    that have already got base factory with ParserFactory.instance()
    but didn't use it yet.
     */
    try {
        Field f = JavaCompiler.class.getDeclaredField("parserFactory");
        f.setAccessible(true);
        f.set(JavaCompiler.instance(context), factory);
    } catch (NoSuchFieldException | IllegalAccessException e) {
        throw new RuntimeException(e);
    }