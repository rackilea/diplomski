List<TopUsers> usersList = getTopArtists();

Iterator<TopUsers> iter = usersList.iterator();
while(iter.hasNext()){
    //Getb the iterated element
    TopUsers user = (TopUsers) iter.next();

    //Check for the subs 
    //use the getSubs() getter to get the list of subs
    if(user.getSubs().isEmpty()) {
      System.out.println("No subs found");
    }
}