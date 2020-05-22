b1.setOnAction(new EventHandler<ActionEvent>() {
    public void handle(ActionEvent event){
        // may need to use boolean fields or .equals(...) method......
        if (someStateField == someValue) {
            doBehavior1();
        } else {
            doBehavior2();
        }
    }
}