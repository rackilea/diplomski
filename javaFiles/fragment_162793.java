@Service
public class HelloWorld {

    @Handler
    public Map<?, ?> returnMap(){
        SensorGenerator sensorGenerator = new SensorGenerator();