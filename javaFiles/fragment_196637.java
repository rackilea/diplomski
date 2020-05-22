import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

import org.reactfx.EventStream;
import org.reactfx.EventStreams;

class ChartData {
    private final ScheduledExecutorService scheduler =
            Executors.newSingleThreadScheduledExecutor();
    private final Executor executor = scheduler;

    EventStream<Double> pieProp1 = randomDoubleStream();
    EventStream<Double> pieProp2 = randomDoubleStream();
    EventStream<Double> pieProp3 = randomDoubleStream();
    EventStream<Double> pieProp4 = randomDoubleStream();
    EventStream<Double> pieProp5 = randomDoubleStream();

    private EventStream<Double> randomDoubleStream() {
        return EventStreams.ticks(Duration.ofMillis(100), scheduler, executor)
                .supply(() -> Math.random() * 30)
                .threadBridgeToFx(executor);
    }

    public void dispose() {
        scheduler.shutdown();
    }
}

public class AsyncChart extends Application {

    @Override
    public void start(Stage s){
        PieChart pc = new PieChart();
        ObservableList<PieChart.Data> chartData = FXCollections.observableArrayList();
        chartData.add(new PieChart.Data("Dat1", 0.0));
        chartData.add(new PieChart.Data("Dat2", 0.0));
        chartData.add(new PieChart.Data("Dat3", 0.0));
        chartData.add(new PieChart.Data("Dat4", 0.0));
        chartData.add(new PieChart.Data("Dat5", 0.0));
        pc.setLegendVisible(false);

        ChartData cd = new ChartData();
        cd.pieProp1.feedTo(chartData.get(0).pieValueProperty());
        cd.pieProp2.feedTo(chartData.get(1).pieValueProperty());
        cd.pieProp3.feedTo(chartData.get(2).pieValueProperty());
        cd.pieProp4.feedTo(chartData.get(3).pieValueProperty());
        cd.pieProp5.feedTo(chartData.get(4).pieValueProperty());

        pc.setData(chartData);

        Scene sc = new Scene(pc);

        s.setScene(sc);
        s.setOnHidden(evt -> cd.dispose());
        s.show();
    }

    public static void main (String[] args){
        launch(args);
    }
}