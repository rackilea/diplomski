public interface SixNumbersModel {        
    public Player getCurrentTurn();        
    public Player nextTurn();        
    public int roll();        
    public boolean hasWon(Player player);        
    public Set<Integer> getPlayerResults(Player player);
    public int getTurnsCount(Player player);        
    public void addChangeListener(ChangeListener listener);
    public void removeChangeListener(ChangeListener listener);
}