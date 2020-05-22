@FXML
public void onjosephclick() {
    //weekPickerInput();                                //You can delete from here
    //addFilmsInList();
    //filmList.setShowLocation("Joseph P");
    //System.out.println("joseph button pressed");
    //try {
    //    Pane pane = FXMLLoader.load(getClass().getResource("scenes/josephpane.fxml"));
    //    seatsSelection.getChildren().setAll(pane);
    //} catch (IOException e) {
    //    System.out.println(e);
    //}
    //setStuff();
    //seatsavailable.setText(Integer.toString(seatsJoseph));
    //filmPrice = filmList.searchFilm().get().getPrice();
    //System.out.println("Price:"+filmPrice);            //Down to here
    genericOnClick("Joseph P","scenes/josephpane.fxml",seatsJoseph);
    //change the strings for each call and remove the unnecessary stuff 
    //in the methods it will clean it up a lot
}

private void genericOnClick(String location, String resourceLocation, int seats) {
    weekPickerInput();
    addFilmsInList();
    filmList.setShowLocation(location);
    System.out.println("Location:"+location);
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resourceLocation));
        Pane pane = loader.load();
        TheatresController controller = loader.getController();
        controller.setDashBoardUserControllerReference(this);
        seatsSelection.getChildren().setAll(pane);
    } catch (IOException e) {
        System.out.println(e);
    }
    setStuff();
    seatsavailable.setText(Integer.toString(seats));
    filmPrice = filmList.searchFilm().get().getPrice();
    System.out.println("Price:"+filmPrice);
}