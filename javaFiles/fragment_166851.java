private void getCamera() {
    if (camera == null) {
        try {
            camera = Camera.open();
            params = camera.getParameters();
        } catch (RuntimeException e) {
            Log.e("Camera Error. Failed to Open. Error: ", e.getMessage());
            if(e.getMessage() == null) {
                errorMessage = "Camera Error.  Failed to Open.  Error message is null"; //here//
            }

            else {
                Log.e("Camera Error.  Failed to Open.  Error: ", e.getMessage());
            }
        }
    }
}