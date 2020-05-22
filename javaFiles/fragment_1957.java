class MyMapParameterConsumer implements IParameterConsumer {
    @Override
    public void consumeParameters(
            Stack<String> args, 
            ArgSpec argSpec, 
            CommandSpec commandSpec) {

        if (args.isEmpty()) {
            throw new ParameterException(commandSpec.commandLine(), 
                    "Missing required parameter");
        }
        String parameter = args.pop();
        String[] keyValue = parameter.split("=", 1);
        String key = keyValue[0];
        String value = keyValue.length > 1 
                ? keyValue[1]
                : "MY_DEFAULT";
        Map<String, String> map = argSpec.getValue();
        map.put(key, value);
    }
}