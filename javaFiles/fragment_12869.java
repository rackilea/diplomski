final Label message = new Label();
        grid.add(message, 1, 7);
        pwBox.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent e) {

                if (!pwBox.getText().equals("T2f$Ay!")) {
                    message.setText("Your password is incorrect!");
                    message.setTextFill(Color.rgb(210, 39, 30)); //Red
                } else {
                    message.setText("Your password has been confirmed");
                    message.setTextFill(Color.rgb(21, 117, 84)); //Green
                }
                pwBox.clear();
            }

        });