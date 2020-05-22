for (Map<String, String> map : fr.values()) {
    for(Map.Entry<String, String> e : map.entrySet()) {
        System.out.println(index + " = " + e.getKey() 
            + " : " + e.getValue());
    }
}