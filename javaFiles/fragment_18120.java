public class ModbusConnection extends Thread {

    @Override
    public void run() {
        while (start) {
            ...
            time_output.getData().add(new XYChart.Data<String, Number>(time, output));
            ...               
        }
    }
}