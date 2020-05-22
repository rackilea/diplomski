// Master map of ToolBean to map of Chamber objects
Map<ToolBean, Map<String, Chamber>> toolBeanToChamberMap = 
    new LinkedHashMap<ToolBean,Map<String,Chamber>>();

// A tool bean and a chamber
ToolBean tb1 = new ToolBean(...);
Chamber  ch1 = new Chamber(...);

// Create a map that will contain Chambers and their String keys
Map<String,Chamber> chMap = new LinkedHashMap<String,Chamber>();

// Put the Chamber into this map
chMap.put("one",ch1);

// Put the map of Chambers into the master map, keyed off the ToolBean
toolBeanToChamberMap.put(tb1, chMap);

// sometime later ...

ToolBean tb2 = ... // may be the same as tb1

// A new Chamber to be added to the data structure
Chamber ch2 = new Chamber(...);

// First find the Chamber map in the master map, matching the ToolBean of interest
Map<String,Chamber> temp = toolBeanToChamberMap.get(tb2);

// 'temp' is a reference to the submap - if it's null, this ToolBean wasn't in the master map yet
if (temp == null) {
    // So create a new empty submap
    temp = new LinkedHashMap<String,Chamber>();
    // Add it to the master map
    toolBeanToChamberMap.put(tb2,temp);
}
// At this point 'temp' is either the pre-existing submap or the one we just added
temp.put("two",ch2);