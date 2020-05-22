public interface ISensor {

    /**
     * Returns a SensorInfo object that describes this sensor.
     */
    public ISensor.SensorInfo getSensorInfo();

    /**
     * Asks the sensor for a (possibly old) datapoint. Synchronous: returns
     * immediately, even if that means returning an old value.
     */
    public ISensor.SensorResponse getData();

    /**
     * Asks the sensor for a new datapoint. Asynchronous.
     * 
     * @param handler
     *            A Handler object to be executed when the sensor has a new
     *            value. If this Sensor is event-based, this method starts
     *            listening for data, and calls the handler whenever new events
     *            are detected.
     */
    public void getData(ISensor.SensorListener handler);

    public static class SensorInfo { }
    public static class SensorResponse { }
    public static class SensorListener { }
}