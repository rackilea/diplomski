Set<Player> randomSet(List<Player> list,int n){

    ArrayList<Player> possiblePlayers = new ArrayList<>();   // fist we create a list where we can put all players that have 10000 runs

    for(Player player: list){             // we loop through the list 
        if(player.getRuns()> 10000){      // check each player if he had more than 10000 runs
            possiblePlayers.add(player);   // and if so, we add him to our list of possible results
        }
    }

    // at this point we have a list of players that have more than 10000 runs and we need to randomly select a player and put him into the new Set

    // so first we create a Set that we can return
    Set<Player> resultSet = new HashSet<>();  // Set is abstract and needs an implemented class like HashSet. This may not be the most appropriate implementation for your case, but it will do for now.

     // now we need to pick n random players from our list. So we actually generate n numbers that we use as indexes

    Random random = new Random();   // first we instantiate our random generator
    ArrayList<Integer> indexes = new ArrayList<>();  // we will use this list to store the generated indexes, so we can check that we don't pick the same index twice


    while (n > 0) {
        Integer randomIndex = random.nextInt(possiblePlayers.size());  // first we pick a number between 0 and the size of our possiblePlayers list
        if (!indexes.contains(randomIndex)) {   // then we check if that number is already in the indexes list
            indexes.add(randomIndex);  // if not, we add it 
            n--;  // and decrement n;
        }
         // if the random number where already in the indexes list, the loop would simply continue and try again
    }

    // here we have now a lost of randomly generated (and unique) indexes
    // now we get the players at that indexes and put them in the result set

    for(Integer index: indexes){
       resultSet.add(possiblePlayers.get(index));
    }

    // and finally return the set
    return resultSet;          
}