Map<String, Integer> commentsCountMap = new HashMap<>();
// Loop through the discussion Map
for(Result res : discussionsList) {
    String parentCommentId = res.getParentCommentID();
    // If the Result has a parent comment
    if(parentCommentId != null) {
        // get the count for this parent comment (default to 0)
        int nbCommentsForParent = commentsCountMap.getOrDefault(parentCommentId, 0);
        // increment the count
        nbCommentsForParent++;
        // Update the Map with the new count
        commentsCountMap.put(parentCommentId, nbCommentsForParent);
    }
}

System.out.println(commentsCountMap);