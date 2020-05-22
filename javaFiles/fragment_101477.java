public class BarChartExample extends Application {

final static String project = "Project - 20%";
final static String quiz = "Quiz - 10%";
final static String midterm = "Midterm - 30%";
final static String finalexam = "Final - 40%";

@Override
public void start(Stage primaryStage) throws Exception{
    primaryStage.setTitle("Change Bar Color Example");
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    final BarChart<String,Number> barChart = new BarChart<String,Number>(xAxis,yAxis);
    xAxis.setLabel("Assignment Type");
    yAxis.setLabel("Percentage");

    XYChart.Series series = new XYChart.Series();
    series.getData().add(new XYChart.Data(project, 20));
    series.getData().add(new XYChart.Data(quiz, 10));
    series.getData().add(new XYChart.Data(midterm, 30));
    series.getData().add(new XYChart.Data(finalexam, 40));
    barChart.getData().add(series);