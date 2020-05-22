/**
 * Set Screen 
 * 
 * @param view
 * @return boolean
 */
public boolean setScreen(Parent view) {       
    final DoubleProperty opacity = stackPane.opacityProperty();

    if (!stackPane.getChildren().isEmpty()) {    //if there is more than one screen
        Timeline fade = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                new KeyFrame(new Duration(TRANSITION_TIMER), new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        stackPane.getChildren().remove(0);        //remove the displayed screen
                        stackPane.getChildren().add(0, view);     //add the screen
                        Timeline fadeIn = new Timeline(
                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                                new KeyFrame(new Duration(TRANSITION_TIMER), new KeyValue(opacity, 1.0)));
                        fadeIn.play();
                    }
                }, new KeyValue(opacity, 0.0)));
        fade.play();

    } else {
        stackPane.setOpacity(0.0);
        stackPane.getChildren().add(view);       //no one else been displayed, then just show
        Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(TRANSITION_TIMER), new KeyValue(opacity, 1.0)));
        fadeIn.play();
    }
    return true;
}