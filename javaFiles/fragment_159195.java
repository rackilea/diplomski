ScriptContext context = new SimpleScriptContext();
context.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);

//Exception handling omitted for brevity

//Evaluate the compiled runtime in our new context
compiledRuntime.eval(context); 

//Evaluate the source in the same context
engine.eval(source, context);

//Call a function
JSObject jsObject = (JSObject) context.getAttribute(function, ScriptContext.ENGINE_SCOPE);
jsObject.call(null, args);