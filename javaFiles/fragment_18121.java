public class ModbusConnection extends Thread {

    @Override
    public void run() {
        while (start) {
            ...
            Platform.runLater(() -> 
                time_output.getData().add(new XYChart.Data<String, Number>(time, output)));
            ...               
        }
    }
}