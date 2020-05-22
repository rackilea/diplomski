public void deleteAllLocations(){
    try{
        LocationUtil.removeAll();
    }catch(Exception ex){
        // Log exception here.
    }
}