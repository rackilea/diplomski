public <T> T getItemsByType(Class<T> clazz) {
    T[] retarr = null;
    for(int i = 0; i<items.size(); i++){
        if(clazz.isInstance(items.get(i))){
            //do your logic here...
        }
    }
    return null;
}