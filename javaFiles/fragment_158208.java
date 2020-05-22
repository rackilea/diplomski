public VariableResolverFactory getMvelFactory(Map contextMap) {
        VariableResolverFactory functionFactory = new MapVariableResolverFactory(contextMap);
        MVEL.eval("checkNullValue = def (x) { x == null ? 0 : x };", functionFactory);

        return functionFactory;
    }