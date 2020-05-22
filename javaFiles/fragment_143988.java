Map<Enum<?>, TypeHandler> myMap = new HashMap<>();
myMap.put(EnumA.FIRST, someHandler);
myMap.put(EnumB.ONE, someOtherHandler);

...

TypeHandler firstHandler = myMap.get(EnumA.FIRST);
TypeHandler oneHandler = myMap.get(EnumB.ONE);