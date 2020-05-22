/Created a 'registerPlayerList'  List 
     List<RegisterPlayer> registerPlayerList = new ArrayList<RegisterPlayer>();
    //  Intialiaze the RegisterPlayer class
            RegisterPlayer playerObj = new RegisterPlayer();
    //set all the values into the object        
            playerObj.setId(rs.getInt("ID"));
            playerObj.setName(rs.getString("FIRST_NAME"));
            playerObj.setEmail(rs.getString("EMAIL"));
            ......
    //add the playerObj to the created registerPlayerList
            registerPlayerList.add(playerObj);

    // return the list      
            return registerPlayerList ;