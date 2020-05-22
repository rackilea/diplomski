Timeline timeline = new Timeline();
KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), e -> {
   for (Building building : theSuperKawaiBuildingList) {
      building.setPopulation(building.getPopulation() + 1);
   }
});
timeline.getKeyFrames().add(keyFrame);
timeline.setCycleCount(Animation.INDEFINITE);
timeline.play();