private Place previousPlace;
private Place currentPlace;

eventBus.addHandler(PlaceChangeEvent.TYPE, new PlaceChangeEvent.Handler() {

      public void onPlaceChange(PlaceChangeEvent event) {

          previousPlace = currentPlace;
          currentPlace = event.getNewPlace();
      }
  });