LoggerContext c1 = new LoggerContext();
    LoggerContext c2 = new LoggerContext();
    new ContextInitializer(c1).configureByResource(new URL("file:logback1.xml"));
    new ContextInitializer(c2).configureByResource(new URL("file:logback2.xml"));
    Logger l1 = c1.getLogger("x");
    Logger l2 = c2.getLogger("x");