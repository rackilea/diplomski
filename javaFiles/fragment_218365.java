menu.setOnShowing(new EventHandler<Event>() {

        @Override
        public void handle(Event t)
        menubar.setStyle("-fx-background-color:transparent"); //
       // or you can use set opacity property
       menubar.setOpacity(0.25);
        }
    });