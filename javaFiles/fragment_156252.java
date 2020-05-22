String[] parameters = {"Hello kitty"};
for (int index = 0; index < commands.size(); index++) {
    String value = commands.get(index);
    if (value.startsWith("%")) {
        int parameter = Integer.parseInt(value.substring(1)) - 1;
        if (parameter < parameters.length) {
            commands.set(index, parameters[parameter]);
        }
        // You might want to think about what you want to do if you have
        // more parameter marks then you do have actual parameter values
    }
}
System.out.println(commands);