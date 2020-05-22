import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CustomListCellSample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Simple Interface
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(10));

        // Create a simple ListView
        ListView<Book> lvBooks = new ListView<>();

        // Populate our ListView with some sample books
        lvBooks.getItems().addAll(
                new Book("Great Expectations", "Charles Dickens"),
                new Book("Pride and Prejudice", "Jane Austen"),
                new Book("To Kill a Mockingbird", "Harper Lee"),
                new Book("1984", "George Orwell")
        );

        // We want to display the title of the Book in our ListView and show the author as a Tooltip
        // To do so, let's provide our own CellFactory
        lvBooks.setCellFactory(cell -> new ListCell<Book>() {

            // We want to create a single Tooltip that will be reused, as needed. We will simply update the text
            // for the Tooltip for each cell
            final Tooltip tooltip = new Tooltip();

            // We will override the updateItem() method of the ListCell so we can setup exactly what we want displayed
            // in each cell.  For this example, we'll just use the text of the cell, but you could also provide your
            // own layout entirely, by calling setGraphic() instead of the setText() used below.
            @Override
            protected void updateItem(Book book, boolean empty) {
                super.updateItem(book, empty);

                if (book == null || empty) {
                    // No book to display here (empty cell) so we clear the text and Tooltip
                    setText(null);
                    setTooltip(null);
                } else {
                    // A book is to be listed in this cell
                    setText(book.getTitle());

                    // Let's show our Author when the user hovers the mouse cursor over this row
                    tooltip.setText(book.getAuthor());
                    setTooltip(tooltip);
                }
            }
        });

        // Finally, add the ListView to our root VBox
        root.getChildren().add(lvBooks);


        // Show the stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("CustomListCellSample Sample");
        primaryStage.show();

    }
}

// Simple Book class to be used as our data model
class Book {

    private final StringProperty title = new SimpleStringProperty();
    private final StringProperty author = new SimpleStringProperty();

    public Book(String title, String author) {
        this.title.set(title);
        this.author.set(author);
    }

    public String getTitle() {
        return title.get();
    }

    public StringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getAuthor() {
        return author.get();
    }

    public StringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }
}