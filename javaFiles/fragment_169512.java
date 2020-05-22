Map<String, String> myMap = new HashMap<> ();
myMap.entrySet ()
    .parallelStream ()
    .forEach (entry -> {
        String key = entry.getKey ();
        String value = entry.getValue ();
        // here add whatever processing you wanna do using the key / value retrieved
        // ret.put (....);
        // ret2.put (....)
    });