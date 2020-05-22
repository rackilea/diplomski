// declare a map of lists, somewhere before you first need to access it
Map<Integer, List<String>> brokenLinkMap = new HashMap<Integer, List<String>>(4);

// use the map, in your current if block
if(statusCode != 200){
    System.out.println((String) x.get(i) + statusCode + statusMessage);
    if(! brokenLinkMap.containsKey(statusCode)) {
        List<String> brokenLinkList = new ArrayList<String>(8);
        brokenLinkMap.put(statusCode, brokenLinkList);
    }

    brokenLinkMap.get(statusCode).add(url.toExternalForm()); // <-- adding to the map!
}

// after all links have been processed, you can dump the map contents
for(final Integer key : brokenLinkMap.keys()) {
    System.out.printf("Broken link count for status %s: %s\n", key, brokenLinkMap.get(key).size());
}