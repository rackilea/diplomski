try{
    UUID uuid = UUID.fromString(someUUID);
    //do something
} catch (IllegalArgumentException exception){
   //handle the case where string is not valid UUID 
}