RenjinScriptEngineFactory engineFactory = new 
RenjinScriptEngineFactory();
ScriptEngine engine = engineFactory.getScriptEngine();
engine.getContext().setWriter(CharStreams.nullWriter()); // std out
engine.getContext().setErrorWriter(CharStreams.nullWriter()); // std err
engine.eval("print(1:99)");   // will not appear in process std out