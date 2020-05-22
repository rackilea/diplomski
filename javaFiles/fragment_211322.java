private final static Map<String, Factory<? extends Communicator>> map;
static {
    map.put("AD", ADCommunicatorFactory.getInstance());
    //...
    map.put(null, NullFactory<Communicator>.getInstance());
} // populated on class-load. Eliminates race from lazy init

// on get
return map.get(type).make();