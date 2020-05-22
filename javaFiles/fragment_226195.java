Set<String> addedIds = new HashSet<String>();

//get your db resultset and do loop

if(addedIds.contains(requestId)){
    //Do not print this requestId in html table
} else {
    //Print the id in html table
    addedIds.add(requestId);
}