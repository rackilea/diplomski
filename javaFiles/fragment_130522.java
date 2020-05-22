import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.print.PrinterJob;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FxTableViewExample1 extends Application
{

    private TableView<Book> table;
    private ObservableList<Book> data;
    private Text actionStatus;

    public static void main(String[] args)
    {

        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage)
    {

        primaryStage.setTitle("Table View Example 1");

        // Books label
        Label label = new Label("Books");
        label.setTextFill(Color.DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 36));
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(label);

        // Table view, data, columns and properties
        table = new TableView();
        data = getInitialTableData();
        table.setItems(data);

        TableColumn titleCol = new TableColumn("Title");
        titleCol.setCellValueFactory(new PropertyValueFactory("title"));
        TableColumn authorCol = new TableColumn("Author");
        authorCol.setCellValueFactory(new PropertyValueFactory("author"));

        table.getColumns().setAll(titleCol, authorCol);
        table.setPrefWidth(450);
        table.setPrefHeight(300);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Status message text
        actionStatus = new Text();
        actionStatus.setFill(Color.FIREBRICK);

        Button button = new Button("Print");

        // Vbox
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));;
        vbox.getChildren().addAll(hb, table, actionStatus, button);

        // Scene
        Scene scene = new Scene(vbox, 500, 475); // w x h
        primaryStage.setScene(scene);
        primaryStage.show();

        // Select the first row
        table.getSelectionModel().select(0);
        Book book = table.getSelectionModel().getSelectedItem();
        actionStatus.setText(book.toString());

        List<List<Book>> bookLists = partition(data, 10);

        button.setOnAction((event) -> {
            PrinterJob printerJob = PrinterJob.createPrinterJob();
            printerJob.showPrintDialog(primaryStage);
            for (int i = 0; i < bookLists.size(); i++) {
                data.clear();
                data.addAll(bookLists.get(i));
                printerJob.printPage(table);
            }

            printerJob.endJob();

        });

    }

    private ObservableList getInitialTableData()
    {
        List list = new ArrayList();
        list.add(new Book("The Thief", "Fuminori Nakamura"));
        list.add(new Book("Of Human Bondage", "Somerset Maugham"));
        list.add(new Book("The Bluest Eye", "Toni Morrison"));
        list.add(new Book("I Am Ok You Are Ok", "Thomas Harris"));
        list.add(new Book("Magnificent Obsession", "Lloyd C Douglas"));
        list.add(new Book("100 Years of Solitude", "Gabriel Garcia Marquez"));
        list.add(new Book("What the Dog Saw", "Malcolm Gladwell"));
        list.add(new Book("The Fakir", "Ruzbeh Bharucha"));
        list.add(new Book("The Hobbit", "J.R.R. Tolkien"));
        list.add(new Book("Strange Life of Ivan Osokin", "P.D. Ouspensky"));
        list.add(new Book("The Hunt for Red October", "Tom Clancy"));
        list.add(new Book("Coma", "Robin Cook"));

        list.add(new Book("A Catskill Eagle", "xxx"));
        list.add(new Book("The Children of Men", "xxx"));
        list.add(new Book("Clouds of Witness", "xxx"));
        list.add(new Book("A Confederacy of Dunces", "xxx"));
        list.add(new Book("Consider Phlebas", "xxx"));
        list.add(new Book("Consider the Lilies", "xxx"));
        list.add(new Book("Cover Her Face", "xxx"));
        list.add(new Book("The Cricket on the Hearth", "xxx"));
        list.add(new Book("The Curious Incident of the Dog in the Night-Time", "xxx"));
        list.add(new Book("The Daffodil Sky", "xxx"));
        list.add(new Book("Dance Dance Dance", "xxx"));
        list.add(new Book("A Darkling Plain", "xxx"));

        list.add(new Book("The Thief", "Fuminori Nakamura"));
        list.add(new Book("Of Human Bondage", "Somerset Maugham"));
        list.add(new Book("The Bluest Eye", "Toni Morrison"));
        list.add(new Book("I Am Ok You Are Ok", "Thomas Harris"));
        list.add(new Book("Magnificent Obsession", "Lloyd C Douglas"));
        list.add(new Book("100 Years of Solitude", "Gabriel Garcia Marquez"));
        list.add(new Book("What the Dog Saw", "Malcolm Gladwell"));
        list.add(new Book("The Fakir", "Ruzbeh Bharucha"));
        list.add(new Book("The Hobbit", "J.R.R. Tolkien"));
        list.add(new Book("Strange Life of Ivan Osokin", "P.D. Ouspensky"));
        list.add(new Book("The Hunt for Red October", "Tom Clancy"));
        list.add(new Book("Coma", "Robin Cook"));

        list.add(new Book("A Catskill Eagle", "xxx"));
        list.add(new Book("The Children of Men", "xxx"));
        list.add(new Book("Clouds of Witness", "xxx"));
        list.add(new Book("A Confederacy of Dunces", "xxx"));
        list.add(new Book("Consider Phlebas", "xxx"));
        list.add(new Book("Consider the Lilies", "xxx"));
        list.add(new Book("Cover Her Face", "xxx"));
        list.add(new Book("The Cricket on the Hearth", "xxx"));
        list.add(new Book("The Curious Incident of the Dog in the Night-Time", "xxx"));
        list.add(new Book("The Daffodil Sky", "xxx"));
        list.add(new Book("Dance Dance Dance", "xxx"));
        list.add(new Book("A Darkling Plain", "xxx"));

        return FXCollections.observableList(list);
    }

    private static <T> List<List<T>> partition(Collection<T> members, int maxSize)
    {
        List<List<T>> res = new ArrayList<>();

        List<T> internal = new ArrayList<>();

        for (T member : members) {
            internal.add(member);

            if (internal.size() == maxSize) {
                res.add(internal);
                internal = new ArrayList<>();
            }
        }
        if (internal.isEmpty() == false) {
            res.add(internal);
        }
        return res;
    }
}