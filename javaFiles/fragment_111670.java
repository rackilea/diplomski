byte[] result = { 
     '{',
     '{', 
     commandMap.get(commandName), 
     dataIdMap.get(dataId), 
     locationMap.get(memLocation), 
     (byte) (commandMap.get(commandName) + dataIdMap.get(dataId) + locationMap.get(memLocation)), 
     '}', 
     '}', 
     '\r' };
return result;