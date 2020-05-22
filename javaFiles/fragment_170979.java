public class SomeController: SpaceViewDataSource, Observer {
    private SpaceView spaceView;
    private Space spaceModel;

    private void configureSpaceView() {
        spaceView.setDataSource(this);
        spaceModel.addObserver(this);
        ...
    }    

    List<Pawn> getPawns() { /* delegate to spaceModel */ }
    Card getCard() { /* delegate to spaceModel */ }

    void update(Observable o, Object arg) {
        if (o == spaceModel) {
            // A fine grained API may be required if
            // this full reload doesn't perform well.
            spaceView.reloadData();
        }
        ...  
    }
    ...
}