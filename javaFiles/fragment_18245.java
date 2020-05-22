System.out.println(Singleton.INSTANCE.toString());
// setting INSTANCE = theNewOne
Singleton theNewOne = createEnumValue(Singleton.INSTANCE.name(), Singleton.INSTANCE.ordinal(), "The new one!");
setFinalField(Singleton.class, Singleton.class.getDeclaredField(Singleton.INSTANCE.name()), theNewOne);
System.out.println(Singleton.INSTANCE.toString());
// setting enum array = [theNewOne]
clearFieldAccessors(getEnumsArrayField(Singleton.class));
setEnumsArray(Singleton.class, theNewOne);
System.out.println(Arrays.toString(Singleton.values()));