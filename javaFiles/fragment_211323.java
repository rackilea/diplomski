// on init
Map<String, Class<? extends Communicator>> map = new HashMap<>();
map.put("AD", ADCommunicator.class);

// on get
try {
    return (Communicator) map.get(type).newInstance();
} catch(InstantiationException | IllegalAccessException | NullPointerException e) {
    return null;
}