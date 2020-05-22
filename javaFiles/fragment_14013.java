for(int i=0; i<=4; i++) {

    for(int j=0; j<=4; j++) {

        final Button myButton = buttonGrid[i][j];

        myButton.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent event) {
                if ("X".equals(myButton.getText())) {
                    myButton.setText("O");
                } else {
                    myButton.setText("X");
                }
            }
        });
    }
}