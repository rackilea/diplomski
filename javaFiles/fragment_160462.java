// Slow setup steps
final MenuOverlay lowOverlay = new MenuOverlay(this, lowRisk);
final MenuOverlay medOverlay = new MenuOverlay(this, medRisk);
final MenuOverlay highOverlay = new MenuOverlay(this, highRisk);

Runnable runnable = new Runnable() {
    public void run() {
        // Anything that touches UI widgets (map, overlay set, views, etc.)
        List<Overlay> mapOverlays = mapView.getOverlays();
        mapOverlays.clear();

        mapOverlays.add(lowOverlay);
        mapOverlays.add(medOverlay);
        mapOverlays.add(highOverlay);

        mapView.invalidate();
    }
};

runOnUiThread(runnable);