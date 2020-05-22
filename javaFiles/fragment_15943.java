Map<String, Map<String, List<ZoneOrders>>> dictionaryfinal = new LinkedHashMap<>();

Map<String, List<ZoneOrders>> dictionaryOrders1 = new LinkedHashMap<>();
dictionaryOrders1.put(zoneland, zoneorder);      

dictionaryfinal.put(zonetype1, dictionaryOrders1);

Map<String, List<ZoneOrders>> dictionaryOrders2 = new LinkedHashMap<>();
dictionaryOrders2.put(zoneland2, zoneorder2);      

dictionaryfinal.put(zonetype2, dictionaryOrders2);