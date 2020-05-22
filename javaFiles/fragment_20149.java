public static ScriptEngine createScriptEngine(ServletContext servletContext) {
    Session session = new SessionBuilder()
        .withFileSystemManager(createAppEngineFileSystemManager(servletContext))
        .withDefaultPackages()
        .build();
    RenjinScriptEngineFactory factory = new RenjinScriptEngineFactory();

    return factory.getScriptEngine(session);
}