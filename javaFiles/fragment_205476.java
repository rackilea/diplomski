final Timeline timeline = new Timeline(new KeyFrame(Duration.ZERO, new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    label.setText(new Date().toString());
                }
            }) , new KeyFrame(Duration.seconds(5)));