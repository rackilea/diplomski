Map<Type, Consumer<Builder>> map = Map.of(
     BOOLEAN, x -> x.add(BOOLEAN.parseBool()),
     STRING, x -> x.add(STRING.parseString())
);


map.get(type).accept(builder);