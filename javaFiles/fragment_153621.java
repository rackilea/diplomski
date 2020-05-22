timeline.setOnFinished(new EventHandler<ActionEvent>(){
        public void handle(final ActionEvent e){
            Platform.runLater(
                    new Runnable(){
                        public void run(){
                            POPUP.hide();
                            popups.remove(POPUP);
                        }
                    }
            );
        }
    });