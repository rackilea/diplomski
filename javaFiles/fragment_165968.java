cameraId = findFrontFacingCamera();
if (cameraId < 0) {
    Toast.makeText(this, "No  camera found.",
        Toast.LENGTH_LONG).show();
} else {
    mcamera = Camera.open(cameraId);
}