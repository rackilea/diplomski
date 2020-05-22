String commandName = "";
String dataId = "";
String memLocation= "";
Map<String, Byte> commandMap = new LinkedHashMap<String, Byte>();
commandMap.put(commandName, Integer.decode("0xD2").byteValue());
Map<String, Byte> dataIdMap = new LinkedHashMap<String, Byte>();
dataIdMap.put(dataId, Integer.decode("0x1").byteValue());
Map<String, Byte> locationMap = new LinkedHashMap<String, Byte>();
locationMap.put(memLocation, Integer.decode("0x00").byteValue());

byte[] result = { '{', '{', commandMap.get(commandName), dataIdMap.get(dataId), locationMap.get(memLocation), (byte) (commandMap.get(commandName) + dataIdMap.get(dataId) + locationMap.get(memLocation)), '}', '}', '\r' };

System.out.println(Arrays.toString(result));