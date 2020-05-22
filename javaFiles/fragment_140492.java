// This listener will be called with information about the given panorama.
OnPanoramaInfoLoadedListener infoLoadedListener =
  new OnPanoramaInfoLoadedListener() {
    @Override
    public void onPanoramaInfoLoaded(ConnectionResult result,
                                     Intent viewerIntent) {
        if (result.isSuccess()) {
            // If the intent is not null, the image can be shown as a
            // panorama.
            if (viewerIntent != null) {
                // Use the given intent to start the panorama viewer.
                startActivity(viewerIntent);
            }
        }

        // If viewerIntent is null, the image is not a viewable panorama.
    }
};

// Create client instance and connect to it.
PanoramaClient client = ...
...

// Once connected to the client, initiate the asynchronous check on whether
// the image is a viewable panorama.
client.loadPanoramaInfo(infoLoadedListener, panoramaUri);