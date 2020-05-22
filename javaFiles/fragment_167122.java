/**
* As an argument you pass a Scene(of Java FX 8 Dialog in my example),
* by closing it you want JFrame to open on same monitor.
**/
public static int getActiveStageLocation(Scene scene){
    List interScreens = Screen.getScreensForRectangle(scene.getWindow().getX(),
            scene.getWindow().getY(),
            scene.getWindow().getWidth(),
            scene.getWindow().getHeight());
    Screen activeScreen = (Screen) interScreens.get(0);
    Rectangle2D r = activeScreen.getBounds();
    double position = r.getMinX();
    return (int) position;
}