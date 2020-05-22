Map<String, ArrayList<UUID>> map = ...
UUID testId = ...
// defined elsewhere

// iterate through the set of elements in the map, produce a string and list for each
map.forEach((string, list) -> { 

    // as the name suggests, removes if the UUID equals the test UUID
    list.removeIf(uuid -> uuid.equals(testId));
});