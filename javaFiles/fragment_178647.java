import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.function.Function;
import java.util.regex.Pattern;

import javafx.application.Application;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyBooleanProperty;
import javafx.beans.property.ReadOnlyBooleanWrapper;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.css.PseudoClass;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class TradeTable extends Application {

    private final Random rng = new Random();

    @Override
    public void start(Stage primaryStage) {
        TableView<Trade> table = new TableView<>();
        table.setEditable(true);
        TableColumn<Trade, Integer> volumeCol = column("Volume", trade -> trade.volumeProperty().asObject());
        TableColumn<Trade, Double> priceCol = column("Price", trade -> trade.priceProperty().asObject());

        priceCol.setCellFactory(col -> new EditingDoubleCell("price-cell"));

        table.getColumns().add(volumeCol);
        table.getColumns().add(priceCol);

        PseudoClass caution = PseudoClass.getPseudoClass("caution");

        table.setRowFactory(tv -> {
            TableRow<Trade> row = new TableRow<>();

            ChangeListener<Boolean> cautionListener = (obs, wasCaution, isNowCaution) -> 
                row.pseudoClassStateChanged(caution, isNowCaution);

            row.itemProperty().addListener((obs, oldTrade, newTrade) -> {
                if (oldTrade != null) {
                    oldTrade.cautionProperty().removeListener(cautionListener);
                }
                if (newTrade == null) {
                    row.pseudoClassStateChanged(caution, false);
                } else {
                    row.pseudoClassStateChanged(caution, newTrade.isCaution());
                    newTrade.cautionProperty().addListener(cautionListener);
                }
            });

            return row ;
        });

        table.getItems().addAll(createRandomData());

        Button button = new Button("Change Data");
        button.setOnAction(e -> table.getItems().forEach(trade -> {
            if (rng.nextDouble() < 0.5) {
                trade.setVolume(0);
            } else {
                trade.setVolume(rng.nextInt(10000));
            }
            trade.setPrice(rng.nextDouble() * 1000);
        }));
        BorderPane.setAlignment(button, Pos.CENTER);
        BorderPane.setMargin(button, new Insets(10));

        BorderPane root = new BorderPane(table, null, null, button, null);
        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("trade-table.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private  List<Trade> createRandomData() {
        List<Trade> trades = new ArrayList<>(50);
        for (int i = 0 ; i < 50; i++) {
            int volume = rng.nextDouble() < 0.5 ? 0 : rng.nextInt(10000) ;
            double price = rng.nextDouble() * 10000 ;
            trades.add(new Trade(price, volume));
        }
        return trades ;
    }

    private static <S,T> TableColumn<S,T> column(String title, Function<S, ObservableValue<T>> property) {
        TableColumn<S,T> col = new TableColumn<>(title);
        col.setCellValueFactory(cellData -> property.apply(cellData.getValue()));
        return col ;
    }

    public static class Trade {
        private DoubleProperty price;
        private IntegerProperty volume ;
        private ReadOnlyBooleanWrapper caution;

        public Trade(double price, int volume){
            this.price = new SimpleDoubleProperty(price);
            this.volume = new SimpleIntegerProperty(volume);
            this.caution = new ReadOnlyBooleanWrapper();
            this.caution.bind(this.volume.greaterThan(0));
        }   

        public double getPrice(){
            return this.price.get();
        }   

        public DoubleProperty priceProperty(){
            return this.price;
        }

        public void setPrice(double price){
            this.price.set(price);
        }

        public final IntegerProperty volumeProperty() {
            return this.volume;
        }

        public final int getVolume() {
            return this.volumeProperty().get();
        }

        public final void setVolume(final int volume) {
            this.volumeProperty().set(volume);
        }

        public final ReadOnlyBooleanProperty cautionProperty() {
            return this.caution.getReadOnlyProperty();
        }

        public final boolean isCaution() {
            return this.cautionProperty().get();
        }


    }

    public static class EditingDoubleCell extends TableCell<Trade,Double>{

        private TextField textField;
        private TextFormatter<Double> textFormatter ;

        private Pattern partialInputPattern = Pattern.compile(
                "[-+]?[,0-9]*(\\.[0-9]*)?");

        private DecimalFormat df ;

        public EditingDoubleCell(String...styleClasses) {
            Locale locale  = new Locale("en", "UK");
            String pattern = "###,###.###";
            df = (DecimalFormat) NumberFormat.getNumberInstance(locale);
            df.applyPattern(pattern);

            getStyleClass().addAll(styleClasses);
        }

        @Override
        public void startEdit() {
            if (!isEmpty()) {
                super.startEdit();
                createTextField();
                setText(null);
                setGraphic(textField);
                textField.requestFocus();
            }
        }

        @Override
        public void cancelEdit() {
            super.cancelEdit();
            setText(df.format(getItem()));
            setGraphic(null);
        }


        @Override
        public void updateItem(Double item, boolean empty) {
            super.updateItem(item, empty);

            if (empty) {
                setText(null);
                setGraphic(null);
            } else {
                if (isEditing()) {
                    if (textField != null) {
                        textField.setText(getString());

                    }
                    setText(null);
                    setGraphic(textField);
                } else {
                    setText(getString());
                    setGraphic(null);
                }
            }
        }

        private String getString() {
            return getItem() == null ? "" : df.format(getItem());
        }

        private void createTextField(){

            textField = new TextField();

            StringConverter<Double> converter = new StringConverter<Double>() {

                @Override
                public String toString(Double number) {
                    return df.format(number);
                }

                @Override
                public Double fromString(String string) {
                    try {
                        double value = df.parse(string).doubleValue() ;
                        return value;
                    } catch (ParseException e) {
                        e.printStackTrace();
                        return 0.0 ;
                    }
                }

            };

            textFormatter = new TextFormatter<>(converter,  0.0, c -> {
                if (partialInputPattern.matcher(c.getControlNewText()).matches()) {
                    return c ;
                } else {
                    return null ;
                }
            }) ;

            // add filter to allow for typing only integer
            textField.setTextFormatter( textFormatter);

            textField.setText( getString() );

            textField.setMinWidth( this.getWidth() - this.getGraphicTextGap() * 2 );

            // commit on Enter
            textFormatter.valueProperty().addListener((obs, oldValue, newValue) -> {
                commitEdit(newValue);
            });
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}