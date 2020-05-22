Set<String> keys = new HashSet<>();
for (String key : testarray) { 
    if(keywords.contains(key)) {
        keys.add(key);
    }
}

System.out.print("Keywords:");
for (String key : keys) {
    System.out.println(key + " ");
}