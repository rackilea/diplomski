public static ArrayList<TagEntity> SearchTagsBy(String title, String tagUId, Boolean status, Boolean pullStatus){

    ArrayList<TagEntity> result = new ArrayList<>();
    ArrayList<TagEntity> tags = GetTagList();

    for(TagEntity tag: tags)
    {
        boolean checkTitle, checkUId, checkStatus, checkPullStatus;

        if(title.isEmpty()) checkTitle = true; else checkTitle = tag.getTitle().contains(title);

        if(tagUId.isEmpty()) checkUId = true; else checkUId = tag.getUId().contains(tagUId);

        if(status == null)checkStatus = true; else checkStatus = tag.getStatus().equals(status);

        if(pullStatus == null)checkPullStatus = true; else checkPullStatus = tag.getHasPulled().equals(pullStatus);

       if( checkTitle && checkUId && checkStatus && checkPullStatus)
             result.add(tag);
    }

    return result;

}