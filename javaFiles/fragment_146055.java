import java.awt.Image;
import java.awt.Graphics2D;
import java.util.*;

public class GameStateManager {

    public static final String EXIT_GAME = "_ExitGame";

    private Map gameStates;
    private Image defaultImage;
    private GameState currentState;
    private InputManager inputManager;
    private boolean done;

    public GameStateManager(InputManager inputManager,
        Image defaultImage)
    {
        this.inputManager = inputManager;
        this.defaultImage = defaultImage;
        gameStates = new HashMap();
    }

    public void addState(GameState state) {        gameStates.put(state.getName(), state);    }

    public Iterator getStates() {        return gameStates.values().iterator();    }

    public void loadAllResources(ResourceManager resourceManager) {
        Iterator i = getStates();
        while (i.hasNext()) {
            GameState gameState = (GameState)i.next();
            gameState.loadResources(resourceManager);
        }
    }

    public boolean isDone() {        return done;    }

    public void setState(String name) {
        // clean up old state
        if (currentState != null) {            currentState.stop();        }
        inputManager.clearAllMaps();

        if (name == EXIT_GAME) {            done = true;        }
        else {
            // set new state
            currentState = (GameState)gameStates.get(name);
            if (currentState != null) {                currentState.start(inputManager);            }
        }
    }

    public void update(long elapsedTime) {
        // if no state, pause a short time
        if (currentState == null) {
            try {
                Thread.sleep(100);
            }
            catch (InterruptedException ex) { }
        }
        else {
            String nextState = currentState.checkForStateChange();
            if (nextState != null) {                setState(nextState);            }
            else {                currentState.update(elapsedTime);            }
        }
    }

    public void draw(Graphics2D g) {
        if (currentState != null) {            currentState.draw(g);        }
        // if no state, draw the default image to the screen
        else {     g.drawImage(defaultImage, 0, 0, null);        }
    }
}