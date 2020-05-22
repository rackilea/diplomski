public class MarketManager {

    // The name of the event.
    private String name = "unkown";

    // Modifier value of the event.
    private float modifier = 0f;

    // The listener to listen for the modifications.
    private Modifier modificationListener;

    // The target stock object towards which the action is directed.
    private Stock target;

    /**
     * Executes the market event.
     */
    public void executeAction() {
        modificationListener.modify(target, modifier);
    }

}