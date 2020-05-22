static class ColoredCell extends ListCell<Float>{
    @Override
    public void updateItem(Float number, boolean empty) {
        super.updateItem(number, empty);

        if(number == null || empty) {
            setText(null);
            setGraphic(null);
        } else {

            setText(number.toString()); // This line is very important!

            if (number < 6.0f){
                this.setTextFill(Color.RED);
            } else {
                this.setTextFill(Color.GREEN);
            }
        }
    }
}