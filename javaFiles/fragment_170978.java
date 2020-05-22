public class SpaceView {
    private SpaceViewDataSource dataSource;

    public void setDataSource(SpaceViewDataSource dataSource) {
        this.dataSource = dataSource;
        reloadData();
        ...
    }

    /** The data source has changed. */
    public void reloadData() { ... } 
    ...
}