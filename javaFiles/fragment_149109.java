public void foo(List<Player> players_list) {

    rx.Observable.from(players_list) // assume players_list is a list contains 2 players
                 .concatMap(player -> getUser(player.getUserId()) // get entity 'User' from DB
                 .map(userObj -> new JsonObject().putString("uid", player.getExtUserId())
                .reduce(new JsonArray(), (seed, acu) -> seed.add(acu))) // build the JsonArray
                .subscribe(playersObj -> { }, 
                           (exception) -> { log.error("", exception); }, 
                          () -> {
    // at this point I expect 'playersArr' to consist 2 entries!
                 });
}