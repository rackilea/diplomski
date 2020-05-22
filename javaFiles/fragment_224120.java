public enum GameState {
    BEGIN, MIDDLE, END;
}

public class GamePanels {
    private Map<GameState, JPanel> lookup = new HashMap<GameState, JPanel> ();
    private JPanel beginPanel;
    private JPanel middlePanel;
    private JPanel endPanel;

    public GamePanels () {
        // Initialize panels

        lookup.put (GameState.BEGIN, beginPanel);
        lookup.put (GameState.MIDDLE, middlePanel);
        lookup.put (GameState.END, endPanel);
    }

    public getPanel (GameState state) {
        JPanel panel = new JPanel ();

        if (lookup.containsKey (state)) {
            panel = lookup.get (state);
        }

        return panel;
    }
}