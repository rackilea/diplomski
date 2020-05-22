public String getCamerasMegaPixel() throws CameraAccessException {
    String output = "";
    CameraManager manager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);

    String[] cameraIds = manager.getCameraIdList();
    CameraCharacteristics characteristics = manager.getCameraCharacteristics(cameraIds[0]);
    output = "back camera mega pixel: " +  calculateMegaPixel(characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE).getWidth(),
            characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE).getHeight()) + "\n";

    characteristics = manager.getCameraCharacteristics(cameraIds[1]);
    output +=  "front camera mega pixel: " + calculateMegaPixel(characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE).getWidth(),characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE).getHeight()) + "\n";
    return output;
}
public float calculateMegaPixel(int width, int height) {
    return (width * height) / 1024000;
}