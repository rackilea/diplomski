ArrayList <Integer> urlSorted = new ArrayList<Integer>();
//sort the url ids
for (Map<String, String> map : getUrlAttachments()) {
    String tmpId = map.get("id");
    if (tmpId.charAt(0) == 'U') {
        //gets the id, removing the prefix 'U'
        urlSorted.add( Integer.valueOf(tmpId.substring(1)));
    }
}
//sort the urlIds to check the sequence they must be added
Collections.sort(urlSorted);
//checks for each url id, compares if it's on the natural order of sorting to be added.
for(Integer urlId: urlSorted) {
    for (Map<String, String> map : getUrlAttachments()) {
        String sortedId = "U"+urlId;
        String tmpId = map.get("id");
        //compare the ids to add the 1, then 2, then 3...
        if (map.get("id").equals(sortedId)) {
                    //code to save according to the sorted ids.
        }
     }
}