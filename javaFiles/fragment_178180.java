private void test() {    
    CompletableFuture<Human> humanFuture =
        lib.getHumanFromDatabase().thenApplyAsync(human -> {
            //returns one human from the database
            return human;
        }, executor).thenComposeAsync(humanFromDb -> {
            //Set new name of human
            humanFromDb.setName("NameOfHuman");
            //update human and return the new entity
            return lib.updateHumanInDatbase(humanFromDb);
        }, executor);

    humanFuture.thenComposeAsync(humanFromDb -> {
          //Then ask for his home
          return lib.getHomeOfHuman(humanFromDb);
      }).thenAcceptBothAsync(humanFuture, (humanFromDb, homeOfHuman) -> {
          //So here you can now access humanFromDb, homeOfHuman

      }, executor).handleAsync((ok, ex) -> {
          //Just for exception and so on

      }, executor);
}