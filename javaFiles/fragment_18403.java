@Override
public void initialize(URL url, ResourceBundle rb) {
    Timeline timeline=new Timeline();
    timeline.getKeyFrames().add(new KeyFrame(Duration.seconds(2), 
            e->VistaNavigator.loadVista(VistaNavigator.VISTA_SCAN_HOME)));
    timeline.play();
}