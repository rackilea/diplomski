public static Map<String, Set<String>> reverseMapping(Map<String, String> mapping)
{
    // slight change in the next line 
    Map <String, Set<String>> remap = new HashMap<String, Set<String>>();
    for (String name : mapping.keySet()) {
        String color = mapping.get(name);
        // Until here its ok, see comment below
    }
    // added the return
    return remap;
}