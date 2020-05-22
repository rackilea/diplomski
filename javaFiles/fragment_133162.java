public class TemperatorSensor 
    implements ISensor 
        <TemperatorSensor.TemperatorInfo, 
         TemperatorSensor.TemperatorResponse, 
         TemperatorSensor.TemperatorListener> 
{

    @Override
    public TemperatorInfo getSensorInfo() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public TemperatorResponse getData() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void getData(TemperatorListener handler) {
        // TODO Auto-generated method stub
    }

    public static final class TemperatorInfo extends ISensor.SensorInfo { }
    public static final class TemperatorResponse extends ISensor.SensorResponse { }
    public static final class TemperatorListener extends ISensor.SensorListener { }
}