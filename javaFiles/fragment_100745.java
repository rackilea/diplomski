private final ConcurrentMap<String, Function> functionMap = new ConcurrentHashMap<>();

public Function getFunction(String key) {
        Function function = functionMap.get(key);
        if (function == null) {
            function = new Function(key);
            Function oldFunction = functionMap.putIfAbscent(function);
            if (oldFunction != null) {
                 function = oldFunction;
            }
        }
        return function;
}