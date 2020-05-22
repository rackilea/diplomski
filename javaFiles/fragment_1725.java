gameTextArea.textProperty().addListener((observable, old_value, new_value) -> {
    Text text = new Text(currText);
    text.setFont(tf.getFont()); 
    double width = text.getLayoutBounds().getWidth()
    if(width > value) {
        //font size smaller
    }
});