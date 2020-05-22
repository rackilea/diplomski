public static void checkRelationship(String key, String value) {
    String val1=hashmap.get(key);  // get "Land_Vehicle"

    // get value by "Land_Vehicle" and compare with "Vehicle"
    if (value.equals(hashmap.get(val1))) {    
        System.out.println("Something is missing in-between");
    }
}