public interface FantasyView {

    public String getFormation();
    public void setFormation(String formation); // Maybe throw an IllegalArgumentException or use an object or enum

    // Other information which the might be useful to return
    public void addFormationChangedObserver(ChangeListener listener);
    public void removeFormationChangedObserver(ChangeListener listener);

    public JComponent getView();

}

public interface SquadModel {
    // Some getters and setters
    // Some observers so the controller and get notified by changes and
    // update the view accordingly...
}

public interface TeamController {
    public FantasyView getView();
    public SquadModel getModel();
}