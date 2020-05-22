class GameParams {
    private int current;
    private int required;
    private int level;
    private int taps;

    // constructor, getters etc.
}

class GameState {
    private int value;
    private int cost;

    // constructor, getters etc.
}

class Game {

    private int maxLevel;                   // initialized to 2 in your case
    private List<GameState> states;         // initialized to {GameState(2,0), GameState(4,5), GameState(9,8)} in your case
    private Map<GameParams, int> cache;

    // constructor, getters etc.

    private int fork(GameParams params) {   // called with GameParams(0, 15, 0, 0)
        if (chache.contains(params))
            return cache.get(params);

        // ...
    }

}