List<DTO> dtoList = getDTOList(); // returns list of DTO object

Map<String,Map<String,String> mapCollection
    = getMapCollection(); // return String, Map<String,String> pairs
List<Map<String,String>> result =  new HashMap<>();

// iterate over dto list
for(DTO singleDTO : dtoList) {
    Map<String,String> singleResult = new HashMap<>();

    // Add all fields in map
    singleResult.put("id",singleDTO.getId());
    singleResult.put("name",singleDTO.getName());
    singleResult.put("desc",singleDTO.getDesc());

    // fetch single map by id lookup
    Map<String,Strig> singleMap = mapCollection.get(singleDTO.getId());
    // fetch all entries from map
    Set<Map.Entry<String,String>> entrySet = singleMap.entrySet();
   // add them in hashmap
    for(Map.Entry<String,String> singleEntry : entrySet) {
        singleResult.put(singleEntry.getKey(),singleEntry.getValue());

    Add map in the list
    result.add(singleEntry);
}}

//result

 [
    {
        "id":"1", "name":"abc", "desc":"some desc abc", "ID":"1", "mapField1":"field1 value",  "mapField2":"field1 value"
    },
    {
        "id":"1", "name":"xyz", "desc":"some desc xyz", "ID":"1", "mapField1":"field1 value",  "mapField2":"field1 value"
    },
    {
        "id":"2", "name":"pqr", "desc":"some desc pqr", "ID":"2", "mapField1":"field1 value 2",  "mapField2":"field1 value2"
    }     
 ]