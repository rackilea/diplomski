public static List<String> friendsArrayObjectIdsArray() {
    //Create Array of Friends
    List<ParseUser> friendsArray = ParseUser.getCurrentUser().getList("friendsArray");

    //Create Temp Array of Object Id's
    List<String> tempObjectIdsArray = new ArrayList<>();

    //Iterate List
    for (ParseUser friendUser : friendsArray) {
        tempObjectIdsArray.add(friendUser.getObjectId());
    }

    return tempObjectIdsArray;
}