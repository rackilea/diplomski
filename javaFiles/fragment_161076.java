public class PlayerTableModel extends AbstractTableModel {
    private final List<PlayerSummary.Player> summaries;

    public PlayerTableModel(List<PlayerSummary.Player> summaries) {
        this.summaries = new ArrayList<PlayerSummary.Player>(summaries);
    }
    // Other TabelModel methods...

    public void refresh() {
        summaries = new ArrayList<>(FileHandler.getCompletedPlayers());
        fireTableDataChanged();
    }
}