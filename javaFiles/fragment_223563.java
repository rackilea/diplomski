new Timer(10000, (e) -> {
   Platform.runLater(() -> {
       for (Building building : theSuperKawaiBuildingList) {
           building.setPopulation(building.getPopulation() + 1);
       }
   });
});