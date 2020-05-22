public void removeSavedUrl(String url,boolean isInternalAccess){
    savedURLs.remove(url);//remove from itemList
    if(!isInternalAccess) {
        for (int i = 0; i <imageList.size() ; i++) {
            if(TextUtils.equals(imageList.get(i).getLink(),url)) {
                imageList.get(i).setIsFavourite(false);//uncheck from pojo
                this.notifyItemChanged(i);
            }
        }

    }
}