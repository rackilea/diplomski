import java.util.Random;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import org.fxmisc.easybind.EasyBind;

public class StackedBarChartExample extends Application {

    private final ObservableList<Title> titles = FXCollections.observableArrayList();
    private final ObservableList<Client> clients = FXCollections.observableArrayList();
    private final ObservableList<Series<String, Number>> mappedSeries = EasyBind.map(
        clients, client -> {
            Series<String, Number> series = new Series<>();
            ObservableList<Data<String, Number>> mappedData = EasyBind.map(
                titles,
                title -> {
                    Data<String, Number> data = new Data<>();
                    data.XValueProperty().bind(title.nameProperty());
                    data.YValueProperty().bind(client.valueProperty(title));
                    return data;
                });
            series.setData(mappedData);
            series.nameProperty().bind(client.nameProperty());
            return series;
        });



    @Override
    public void start(Stage primaryStage) {

        NumberAxis yAxis = new NumberAxis();
        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setAutoRanging(false);
        StackedBarChart<String, Number> barChart = new StackedBarChart<>(xAxis,
                yAxis);
        barChart.setAnimated(false);

        Bindings.bindContent(barChart.getData(), mappedSeries);

        xAxis.setCategories(EasyBind.map(titles, Title::getName));

        Title awaitingResponse = new Title("Awaiting Response");
        Title agreed = new Title("Agreed");
        Title workInProgress = new Title("Work in progress");
        titles.addAll(awaitingResponse, agreed, workInProgress);

        for (int i = 1; i <= 5; i++) {
            Client client = new Client("Test " + i);
            client.setValue(awaitingResponse, i * 1000);
            client.setValue(agreed, 3000);
            client.setValue(workInProgress, (6 - i) * 1000);
            clients.add(client);
        }

        VBox controls = new VBox(5);
        final Random rng = new Random();
        Button newClientButton = new Button("Add client");
        newClientButton.setOnAction(event -> {
            Client client = new Client("Test " + (clients.size() + 1));
            for (Title title : titles) {
                client.setValue(title, rng.nextInt(5000));
            }
            clients.add(client);
        });

        HBox titleControls = new HBox(5);
        titleControls.setAlignment(Pos.CENTER);
        TextField newTitleText = new TextField();
        Button newTitleButton = new Button("Add title");
        newTitleButton.setOnAction(event -> {
            Title title = new Title(newTitleText.getText());
            for (Client client : clients) {
                client.setValue(title, rng.nextInt(5000));
            }
            titles.add(title);
        });
        titleControls.getChildren().addAll(newTitleText, newTitleButton);

        controls.setPadding(new Insets(5));
        controls.setAlignment(Pos.CENTER);
        controls.getChildren().addAll(titleControls, newClientButton);

        BorderPane root = new BorderPane();
        root.setCenter(barChart);
        root.setBottom(controls);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}