for(char alph = 'A'; alph <= 'Z'; alph++){
List<String> friends = getFriends(alph);

if(friends.size() > 0){
//Populate the Sorted Alphabetical view
}
 }

private List<String> getFriends(char alph) {
//Empty List used to populate when comparing existing model to alphabet
List<String> friends = new ArrayList<>();

//5 objects of FriendsData with three parameters
for (int i = 0; i < friendsData.size(); i++){
//If the first string parameter character at position 0 is equal to alph
 String username=friendsData.get(i).getUsername();      //get the username
 if(username.charAt(0) == alph){                        //compare the username with charater in alph variable
 friends.add(username);                                 //add in another list
}
 }

return friends;
}