public void setCalibrationAltitudeAndPressure(float calibrationAltitude, float currentPressure) {
   this.calibrationAltitude = calibrationAltitude;
   this.calibrationPressure = currentPressure;
}

public float getCurrentAltitude(float currentPressure) {
    float altitudeDifference =
            sensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, currentPressure) -
            sensorManager.getAltitude(SensorManager.PRESSURE_STANDARD_ATMOSPHERE, calibrationPresure);
    return calibrationAltitude + altitudeDifference;
}