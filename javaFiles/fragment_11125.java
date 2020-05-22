import java.io.File;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MCVE extends Application {

    private Stage primaryStage;
    private BorderPane rootLayout;
    private VBox detailsView;
    private StatusBar statusBar;

    public void start(Stage primaryStage) throws SQLException {

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("MCVE");

        initRootLayout();
        showStatusBar();
        showDetailsView();

        detailsView.prefWidthProperty().bind(rootLayout.widthProperty());
        detailsView.prefHeightProperty().bind(rootLayout.heightProperty());
    }

    @Override
    public void init() throws Exception {
        super.init();

    }

    public void initRootLayout() {
        rootLayout = new BorderPane();

        primaryStage.setWidth(1000);
        primaryStage.setHeight(600);

        Scene scene = new Scene(rootLayout);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showStatusBar() {
        statusBar = new StatusBar();
        rootLayout.setBottom(statusBar);
    }

    public void showDetailsView() {
        detailsView = new VBox();
        rootLayout.setCenter(detailsView);

        setDetailsView(new Table(this));

        detailsView.prefHeightProperty().bind(primaryStage.heightProperty());
        detailsView.setMaxHeight(Region.USE_PREF_SIZE);
    }

    public static void main(String[] args) {
        launch(args);
    }

    public VBox getDetailsView() {
        return detailsView;
    }

    public void setDetailsView(Node content) {
        detailsView.getChildren().add(0, content);
    }

    public StatusBar getStatusBar() {
        return statusBar;
    }

    class StatusBar extends HBox {
        public StatusBar() {
            setPadding(new Insets(0, 5, 0, 5));

            HBox leftBox = new HBox(10);

            getChildren().addAll(leftBox);

            /**
             * CONTROL SIZES
             */
            setPrefHeight(28);
            setMinHeight(28);
            setMaxHeight(28);

            // Leftbox takes all the space not occupied by the helpbox.
            leftBox.prefWidthProperty().bind(widthProperty());

            setStyle("-fx-border-color: black;");
        }
    }

    class Table extends TableView<ObservableList<String>> {

        private ObservableList<ObservableList<String>> data;

        public Table(MCVE app) {

            prefWidthProperty().bind(app.getDetailsView().widthProperty());
            prefHeightProperty()
                    .bind(app.getDetailsView().heightProperty());

            widthProperty().addListener((obs, oldValue, newValue) -> {
                System.out.println("Table width: " + newValue);
            });

            setRowFactory(r -> {
                TableRow<ObservableList<String>> row = new TableRow<ObservableList<String>>();

                row.setOnDragDetected(e -> {
                    Dragboard db = row.startDragAndDrop(TransferMode.ANY);
                    db.setDragView(row.snapshot(null, null));

                    ArrayList<File> files = new ArrayList<File>();

                    // We create a clipboard and put all of the files that
                    // was selected into the clipboard.
                    ClipboardContent filesToCopyClipboard = new ClipboardContent();
                    filesToCopyClipboard.putFiles(files);

                    db.setContent(filesToCopyClipboard);
                });

                row.setOnDragDone(e -> {
                    e.consume();
                });

                return row;
            });

            ObservableList<String> columnNames = FXCollections.observableArrayList("Col1", "col2", "Col3", "Col4");

            data = FXCollections.observableArrayList();

            for (int i = 0; i < columnNames.size(); i++) {
                final int colIndex = i;

                TableColumn<ObservableList<String>, String> column = new TableColumn<ObservableList<String>, String>(
                        columnNames.get(i));

                column.setCellValueFactory((param) -> new SimpleStringProperty(param.getValue().get(colIndex).toString()));

                    getColumns().add(column);
            }

            // Adds all of the data from the rows the data list.
            for (int i = 0; i < 100; i++) {
                // Each column from the row is a String in the list.
                ObservableList<String> row = FXCollections.observableArrayList();

                row.add("Column 1");
                row.add("Column 2");
                row.add("Column 3");
                row.add("Column 4");

                // Adds the row to data.
                data.add(row);
            }

            // Adds all of the rows in data to the table.
            setItems(data);
        }
    }
}