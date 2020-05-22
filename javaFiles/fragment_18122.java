public class ModbusConnection extends Thread {

    @Override
    public void run() {
        while (start) {
            ...
            Platform.runLater(() -> {
                time_output.getData().add(new XYChart.Data<String, Number>(time, output));
                time_input.getData().add(new XYChart.Data<String, Number>(time, input));
                if (time_output.getData().size() > MEASUREMENTS) {
                    time_output.getData().remove(0); 
                    time_input.getData().remove(0);
                }
            });
            ...               
        }
    }
}