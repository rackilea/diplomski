public class WatchFace extends CanvasWatchFaceService {

    @Override
    public MyEngine onCreateEngine() {
        return new MyEngine();
    }

    private class MyEngine extends CanvasWatchFaceService.Engine { ... }
    // The above line is basically:
    // private class MyEngine extends WatchFace.Engine { ... }
}