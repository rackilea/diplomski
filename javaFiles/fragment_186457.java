private boolean loaded;

private class MyViewer extends JMapViewer {

    @Override
    public void tileLoadingFinished(Tile tile, boolean success) {
        super.tileLoadingFinished(tile, success);
        if (!loaded & success) {
            loaded = true;
            setDisplayToFitMapMarkers();
        }
    }
    …
}