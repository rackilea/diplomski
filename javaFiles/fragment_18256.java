package nodeStatsVision.chartFactory;

    import java.util.ArrayList;
    import javafx.application.Platform;
    import javafx.collections.FXCollections;
    import javafx.collections.ObservableList;
    import javafx.event.EventHandler;
    import javafx.scene.Group;
    import javafx.scene.Node;
    import javafx.scene.Parent;
    import javafx.scene.chart.PieChart;
    import javafx.scene.control.Label;
    import javafx.scene.input.MouseEvent;
    import javafx.scene.layout.StackPane;
    import javafx.scene.paint.Color;
    import nodeStatsVision.beans.ListRepere;
    import nodeStatsVision.beans.OptionsChart;
    import nodeStatsVision.beans.ValueStat;

    /**
     *
     * @author Zombkey.
     */
    public class PieChartNode implements ChartNode {

    private ListRepere categories;
    private ArrayList<ValueStat> values;

    private ObservableList<PieChart.Data> pieChartData; 
    private Group group;
    private Node node;
    private final Label caption;

    public PieChartNode(ListRepere categories, ArrayList<ValueStat> values){
            this.categories = categories;
            this.values = values;

            group = new Group();
            StackPane pane = new StackPane();
            group.getChildren().add(pane);

            pieChartData = FXCollections.observableArrayList();
            node = new PieChart(pieChartData);
            pane.getChildren().add(node);

            caption = new Label("");
            caption.setVisible(false);
            caption.getStyleClass().addAll("chart-line-symbol", "chart-series-line");
            caption.setStyle("-fx-font-size: 12; -fx-font-weight: bold;");
            caption.setMinSize(Label.USE_PREF_SIZE, Label.USE_PREF_SIZE);
            pane.getChildren().add(caption);

            Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                            formatData();
                    }
            });
    }

    private void formatData() {

            for(ValueStat v : values){
                    PieChart.Data dataTemp = new PieChart.Data(v.getCategorie().getStringName(),v.getDoubleValue());
                    pieChartData.add(dataTemp);

                    dataTemp.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED,
                    new EventHandler<MouseEvent>() {
                            @Override public void handle(MouseEvent e) {
                                    caption.setTranslateX(e.getX());
                                    caption.setTranslateY(e.getY());
                                    caption.setText(String.valueOf(dataTemp.getPieValue()));
                                    caption.setVisible(true);
                            }
                    });
                    dataTemp.getNode().addEventHandler(MouseEvent.MOUSE_EXITED,
                    new EventHandler<MouseEvent>() {
                            @Override public void handle(MouseEvent e) {
                                    caption.setVisible(false);
                            }
                    });
            }
    }

    @Override
    public Node getNodeGraph() {
            return (Node)group;
    }

    @Override
    public void setOptions(OptionsChart optionsChart) {
            //To implemente
    }

    }