public void loadTicketPage(Film film){
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ticketsPage.fxml"));

        Scene scene = new Scene(loader.load());
        Stage stage = new Stage();

        stage.initModality(Modality.APPLICATION_MODAL);

        stage.setScene(scene);
        stage.setTitle("Ticket Page");

        // get the controller and set the film
        TicketsPageController controller = loader.getController();
        controller.setFilm(film);

        stage.show();
    } catch (IOException e) {
        e.printStackTrace();
    }
}