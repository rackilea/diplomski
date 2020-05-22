public interface ISensor 
    <I extends ISensor.SensorInfo, 
     R extends ISensor.SensorResponse, 
     L extends ISensor.SensorListener> 
{

    /**
    * Returns a SensorInfo object that describes this sensor.
    */
    public I getSensorInfo();

    /**
    * Asks the sensor for a (possibly old) datapoint. Synchronous: returns
    * immediately, even if that means returning an old value.
    */
    public R getData();

    /**
    * Asks the sensor for a new datapoint. Asynchronous.
    * 
    * @param handler
    *            A Handler object to be executed when the sensor has a new
    *            value. If this Sensor is event-based, this method starts
    *            listening for data, and calls the handler whenever new events
    *            are detected.
    */
    public void getData(L handler);

    public static class SensorInfo { }
    public static class SensorResponse { }
    public static class SensorListener { }
}