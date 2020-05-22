public class MyStage extends Stage {
    private boolean debug = false;
    private Window debugWindow = new DebugWindow(); // your customized Window that contains the debug info 
    public MyStage(...) {
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (getTapCount() >= 2) { // i.e., double click
                    debug = !debug;
                }
            }
        });
    }

    public void act() {
        // ...
        if (debug && debugWindow.getStage() != this) {
            addActor(debugWindow); // This will add the debug window to your stage, making the debug info visible
        }
        else if (!debug && debugWindow.getStage() == this) {
            debugWindow.remove(); // When you want the debug window out of the way
        }
    }
}