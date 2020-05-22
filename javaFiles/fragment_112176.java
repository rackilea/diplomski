@FXML
public TableView<Listing> allListings; 
...
for(int i = 0; i < AnotherClass.listings.size(); i++){
    allListingsData.add(new Listing(AnotherClass.listings.get(i))); 
}
...
return new Task<Void>() {
    @Override
    protected Void call() throws Exception {
         while(true){
              synchronized(AnotherClass.listings) {
                  for(int i = 0; i < AnotherClass.listings.size(); i++){
                      Response response = makeAPICall();
                      Platform.runLater(() -> {
                          allListings.getItems().get(i).setIsCompetitive(
                              response.isCompetitive()
                          );
                      }; 
                      Thread.sleep(1000);
                  }
              }
         }
    }
}