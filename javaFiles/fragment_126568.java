private void createListeners(){


screen.widthProperty().addListener((obs, oldVal, newVal) -> {
    if(newVal != oldVal){
        screen.minWidthProperty().bind(screen.heightProperty().multiply(1.77778));
        screen.maxWidthProperty().bind(screen.heightProperty().multiply(1.77778));
        System.out.println("NEW WIDTH OF SCREEN IS: "+newVal);
    }

});

screen.heightProperty().addListener((obs, oldVal, newVal) -> {
    if(newVal != oldVal){
        screen.minWidthProperty().bind(screen.heightProperty().multiply(1.77778));
        screen.maxWidthProperty().bind(screen.heightProperty().multiply(1.77778));
        System.out.println("NEW HEIGHT OF SCREEN IS: "+newVal);
    }

});
}