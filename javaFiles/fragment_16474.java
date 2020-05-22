String[] argsAsString = readValuesFromString(data);
Object[] args = new Object[argAsString.length()];
int i = 0;
Class<?>[] paramTypes = ctor.getParameterTypes();
for (String argStr: argsAsString) {
    args[i] = convertStringToActualType(argStr, paramTypes[i]);
    i++;
}

ctor.newInstance(args);