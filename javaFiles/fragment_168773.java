public class DefaultTeamController implements TeamController {

    private FantasyView view;
    private SquadModel model;

    public DefaultTeamController(FantasyView view, SquadModel model) {
        this.view = view;
        this.model = model;

        view.addFormationChangedObserver(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                SquadModel model = getModel();
                // update model accordingly
            }
        });

        // Add observers to model...
    }

    @Override
    public FantasyView getView() {
        return view;
    }

    @Override
    public SquadModel getModel() {
        return model;
    }

}