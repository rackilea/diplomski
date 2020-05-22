public class DefaultSizeNumbersModel implements SixNumbersModel {

    private List<ChangeListener> changeListeners;
    private Die die = new Die();

    private Player turn;

    private Map<Player, Set<Integer>> results;
    private Map<Player, Integer> turns;

    public DefaultSizeNumbersModel() {
        changeListeners = new ArrayList<>(2);
        results = new HashMap<>();
        results.put(Player.ONE, new HashSet<>(6));
        results.put(Player.TWO, new HashSet<>(6));
        turns = new HashMap<>(2);
        turns.put(Player.ONE, 0);
        turns.put(Player.TWO, 0);
        setCurrentTurn(Player.ONE);
    }

    @Override
    public Player getCurrentTurn() {
        return turn;
    }

    protected void setCurrentTurn(Player player) {
        turn = player;
    }

    @Override
    public Player nextTurn() {
        switch (getCurrentTurn()) {
            case ONE:
                setCurrentTurn(Player.TWO);
                break;
            case TWO:
                setCurrentTurn(Player.ONE);
                break;
            default:
                setCurrentTurn(Player.ONE);
                break;
        }
        fireStateChanged();
        return getCurrentTurn();
    }

    @Override
    public int roll() {
        incrementTurnCount(getCurrentTurn());
        int result = die.Roll();
        Set<Integer> playerResults = results.get(getCurrentTurn());
        playerResults.add(result);
        return result;
    }

    @Override
    public boolean hasWon(Player player) {
        Set<Integer> playerResults = results.get(getCurrentTurn());
        return playerResults.size() == 5; // 0...5
    }

    @Override
    public Set<Integer> getPlayerResults(Player player) {
        Set<Integer> actualResults = results.get(player);
        Set<Integer> copy = new HashSet<>(actualResults);
        return copy;
    }

    @Override
    public int getTurnsCount(Player player) {
        return turns.get(player);
    }

    protected void setTurnsCount(Player player, int count) {
        turns.put(player, count);
    }

    protected void incrementTurnCount(Player player) {
        int count = getTurnsCount(player);
        count++;
        setTurnsCount(player, count);
    }

    @Override
    public void addChangeListener(ChangeListener listener) {
        changeListeners.add(listener);
    }

    @Override
    public void removeChangeListener(ChangeListener listener) {
        changeListeners.remove(listener);
    }

    protected void fireStateChanged() {
        ChangeEvent evt = new ChangeEvent(this);
        for (ChangeListener listener : changeListeners) {
            listener.stateChanged(evt);
        }
    }
}