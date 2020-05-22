switch (event.sensor.getType()) {
        case Sensor.TYPE_ACCELEROMETER:
            accelerometerValues = event.values.clone();
        case Sensor.TYPE_MAGNETIC_FIELD:
            geomagneticMatrix = event.values.clone();
            sensorReady = true;
            break;
        default:
            break;
    }