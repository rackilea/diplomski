…
private boolean loaded;
…
public JMapViewerTree(String name, boolean treeVisible) {
    …
    map = new JMapViewer() {
        @Override
        public void tileLoadingFinished(Tile tile, boolean success) {
            super.tileLoadingFinished(tile, success);
            if (!loaded & success) {
                loaded = true;
                setDisplayToFitMapMarkers();
            }
        }
    };
    …
}