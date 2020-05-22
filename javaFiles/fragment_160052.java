ScriptContext engineContext = engine.getContext()

ScriptContext context = new SimpleScriptContext();
context.setBindings(
    engineContext.getBindings(ScriptContext.ENGINE_SCOPE),
    ScriptContext.ENGINE_SCOPE
);

engine.eval(myScript, myContext);