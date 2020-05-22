// declare a multimap, somewhere before you need to first access it
Multimap<Integer, String> brokenLinkMap = ArrayListMultiMap.create();

// use the map, in your current if block
if(statusCode != 200){
    System.out.println((String) x.get(i) + statusCode + statusMessage);
    brokenLinkMap.put(statusCode, url.toExternalForm()); // <-- adding to the map!
}

// after all links have been processed, you can dump the map contents
for(final Integer key : brokenLinkMap.keys()) {
    System.out.printf("Broken link count for status %s: %s\n", key, brokenLinkMap.get(key).size());
}