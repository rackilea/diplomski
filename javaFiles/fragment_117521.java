private static int check;
      @Override
        public void initialize(URL location, ResourceBundle resources)
        {
          if(check == 0)
{

            Main.eventBus.addEventHandler(AddClickedEvent.ANY,event -> {
                System.out.println("uyondan bosilib galdi");
                System.out.println(yes);
                yes = true;
            });
check ++;
// Then it will react only once We registered event here
}
            id1.setOnAction(event -> {
                System.out.println(yes);
            });
            id2.setOnAction(event -> {

                Stage stage = (Stage)((Node) (event).getSource()).getScene().getWindow();
                stage.close();
            });

        }