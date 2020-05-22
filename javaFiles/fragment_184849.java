<cfscript>
    ... 
    // not sure about accessing the STATUS_UPDATE enum. One of these should work:
    // method 1 
     STATUS_UPDATE = createObject("java", "com.google.code.linkedinapi.client.enumeration.NetworkUpdateType$STATUS_UPDATE");
    // method 2
    NetworkUpdateType = createObject("java", "com.google.code.linkedinapi.client.enumeration.NetworkUpdateType");
    STATUS_UPDATE = NetworkUpdateType.valueOf("STATUS_UPDATE");

    enumSet = createObject("java", "java.util.EnumSet");
    network = yourClientObject.getNetworkUpdates(enumSet.of(STATUS_UPDATE));
    numOfUpdates = network.getUpdates().getTotal(); 
    // Add error handling in case numOfUpdates = 0
    result = yourClientObject.getNetworkUpdates(numOfUpdates, numOfUpdates); 
    lastUpdate = result.getUpdates().getUpdateList().get(0);
    key = lastUpdate.getUpdateKey();
</cfscript>