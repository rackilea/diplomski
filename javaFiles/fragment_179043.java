public void evaluate() {
    pool.getThreadPoolExecutor().submit(new Runnable() {
        @Override
        public void run() {
            Double result;

            ScriptContext myContext = new SimpleScriptContext();
            Bindings bindings = engine.createBindings();
            bindings.putAll(map);
            myContext.setBindings(bindings, ScriptContext.ENGINE_SCOPE);

            try {
                result = (Double) engine.eval(formula, myContext);
            } catch (ScriptException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    });
}