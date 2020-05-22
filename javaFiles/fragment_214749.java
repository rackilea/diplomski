playButton.setOnAction(new EventHandler<ActionEvent>() {
    @Override
    public void handle(ActionEvent event) {
        final int index = nextTransitionIndex.get();
        Animation anim = transitions.get(index);
        anim.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent evt) {
                nextTransitionIndex.set(index + 1) ;
            }
        });
        anim.setRate(1);
        anim.play();
    }
});