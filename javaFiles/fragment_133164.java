public class TemperatorSensor implements ISensor {

    @Override
    public SensorInfo getSensorInfo() {
        // TODO Auto-generated method stub
        return new TemperatorInfo();
    }

    @Override
    public SensorResponse getData() {
        // TODO Auto-generated method stub
        return new TemperatorResponse();
    }

    @Override
    public void getData(SensorListener handler) {
        if (handler instanceof TemperatorListener) {
            // TODO Auto-generated method stub
        }
    }

    public static final class TemperatorInfo extends ISensor.SensorInfo { }
    public static final class TemperatorResponse extends ISensor.SensorResponse { }
    public static final class TemperatorListener extends ISensor.SensorListener { }
}