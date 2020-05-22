@Override
public void onSensorChanged(SensorEvent event) {
    //Get Rotation Vector Sensor Values
    double[] g = convertFloatsToDoubles(event.values.clone());

    //Normalise
    double norm = Math.sqrt(g[0] * g[0] + g[1] * g[1] + g[2] * g[2] + g[3] * g[3]);
    g[0] /= norm;
    g[1] /= norm;
    g[2] /= norm;
    g[3] /= norm;

    //Set values to commonly known quaternion letter representatives
    double x = g[0];
    double y = g[1];
    double z = g[2];
    double w = g[3];

    //Calculate Pitch in degrees (-180 to 180)
    double sinP = 2.0 * (w * x + y * z);
    double cosP = 1.0 - 2.0 * (x * x + y * y);
    double pitch = Math.atan2(sinP, cosP) * (180 / Math.PI);

    //Calculate Tilt in degrees (-90 to 90)
    double tilt;
    double sinT = 2.0 * (w * y - z * x);
    if (Math.abs(sinT) >= 1)
        tilt = Math.copySign(Math.PI / 2, sinT) * (180 / Math.PI);
    else
        tilt = Math.asin(sinT) * (180 / Math.PI);

    //Calculate Azimuth in degrees (0 to 360; 0 = North, 90 = East, 180 = South, 270 = West)
    double sinA = 2.0 * (w * z + x * y);
    double cosA = 1.0 - 2.0 * (y * y + z * z);
    double azimuth = Math.atan2(sinA, cosA) * (180 / Math.PI);
}