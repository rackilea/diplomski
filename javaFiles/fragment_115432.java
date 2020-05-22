import java.util.Date;
import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleWrapper;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableCell;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableRow;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;

public class StyleTableRow extends Application {

    @Override
    public void start(Stage primaryStage) {
        TreeTableView<ClosedTradesPnL> ttv = new TreeTableView<>(new TreeItem<>(new ClosedTradesPnL()));
        for (int i=0;i<10;i++) ttv.getRoot().getChildren().add(new TreeItem<>(new ClosedTradesPnL()));
        ttv.getRoot().setExpanded(true);

        TreeTableColumn<ClosedTradesPnL, String> symColumn = new TreeTableColumn<>("Symbol");
        symColumn.setCellValueFactory((param) -> 
            new ReadOnlyStringWrapper(param.getValue().getValue().getSymbol())
        );

        TreeTableColumn<ClosedTradesPnL, Date> expiryColumn = new TreeTableColumn<>("Expiry Date");
        expiryColumn.setCellValueFactory((param) -> 
            new ReadOnlyObjectWrapper<>(param.getValue().getValue().getExpiry_date())
        );

        //use Number for type of data in column
        TreeTableColumn<ClosedTradesPnL, Number> pnlColumn = new TreeTableColumn<>("PnL");
        pnlColumn.setCellValueFactory((param) -> 
            new ReadOnlyDoubleWrapper(param.getValue().getValue().getRealized_PNL())
        );

        //now use a cellFactory to style the cell
        //you can get the row and style it as well
        pnlColumn.setCellFactory((TreeTableColumn<ClosedTradesPnL, Number> param) -> {
            TreeTableCell cell = new TreeTableCell<ClosedTradesPnL, Number>(){
                @Override
                //by using Number we don't have to parse a String
                protected void updateItem(Number item, boolean empty) {
                    super.updateItem(item, empty);
                    TreeTableRow<ClosedTradesPnL> ttr = getTreeTableRow();
                    if (item == null || empty){
                        setText(null);
                        ttr.setStyle("");
                        setStyle("");
                    } else {
                        ttr.setStyle(item.doubleValue() > 0 
                                ? "-fx-background-color:lightgreen"
                                : "-fx-background-color:pink");
                        setText(item.toString());
                        setStyle(item.doubleValue() > 0 
                                ? "-fx-background-color:green"
                                : "-fx-background-color:red");
                    }
                }
            };
            return cell;
        });

        ttv.getColumns().setAll(symColumn, expiryColumn,pnlColumn);

        Scene scene = new Scene(ttv, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class ClosedTradesPnL{
        private SimpleStringProperty symbol = new SimpleStringProperty("symbol");
        private SimpleObjectProperty<Date> expiry_date = new SimpleObjectProperty<>(new Date(System.currentTimeMillis()));
        private SimpleDoubleProperty realized_PNL= new SimpleDoubleProperty(Math.random()-0.5);

        public String getSymbol() {return symbol.get();}
        public Date getExpiry_date() {return expiry_date.get();}
        public double getRealized_PNL() {return realized_PNL.get();}

    }
}