public class JSONGameStateFilter() {

    public interface GameInterface1 {
        // callback methods for activity 1
        // example: public void newPlayerArrived(String name, int score);
        // ...
    }

    public interface GameInterface2 {
        // callback methods for activity 2
    }

    public interface GameInterface3 {
        // callback methods for activity 3
    }

    private GameInterface1 callback1;
    private GameInterface2 callback2;
    private GameInterface3 callback3;

    private JSONGameStateFilter instance;

    public static JSONGameStateFilter getInstance() {
        if (instance != null) {
            return instance = new JSONGameStateFilter();
        }
    }
    private JSONGameStateFilter() {}

    public void registerListener(GameInterface1 callback) {
        // called by Activity1 implementing GameInterface1 
        // by JSONGameStateFilter.newInstance().registerListener(this);
        this.callback1 = callback;
    }

    public void registerListener(GameInterface2 callback) {
        this.callback2 = callback;
    }

    public void registerListener(GameInterface3 callback) {
        this.callback3 = callback;
    }

    public void filterJSON(JSONObject object) {
        // read JSON and gamestate
        // depending on situation call the right callback
        // example: if (callback1 != null) callback1.newPlayerArrived(name, score)
    }
}