public void start() {

    SequentialTransition slideshow = new SequentialTransition();

    for (ImageView slide : slides) {

        SequentialTransition sequentialTransition = new SequentialTransition();

        FadeTransition fadeIn = Transition.getFadeTransition(slide, 0.0, 1.0, 2000);
        FadeTransition stayOn = Transition.getFadeTransition(slide, 1.0, 1.0, 2000);
        FadeTransition fadeOut = Transition.getFadeTransition(slide, 1.0, 0.0, 2000);

        sequentialTransition.getChildren().addAll(fadeIn, stayOn, fadeOut);               
        this.root.getChildren().add(slide);            
        slideshow.getChildren().add(sequentialTransition);

    }
    slideshow.play();
}