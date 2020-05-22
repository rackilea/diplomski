private Map<String, String> checkInScopeLobs(Map<String, String> allLobsChkBx) {
    Map<String, String> inScopeLobs = new HashMap();
    List<String> keys = Arrays.asList( { "1", "2", "3" } );
    for(String key : allLobsChkBx.keySet()) {
        if(keys.contains(key)) {
            inScopeLobs.put(key, allLobsChkBx.get(key));
        }
    }
    return inScopeLobs;
}