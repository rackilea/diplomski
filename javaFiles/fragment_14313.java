import java.util.ArrayList;
import java.util.function.Function;

public class Helper {

    public static <T> ObservableList<T> parseItems(Function<String, T> lineToItemFunction, FileHelper fh) {
        // create new Observable List
        ObservableList<T> items = FXCollections.observableArrayList();

        // get lines from file;
        ArrayList<String> arrayList = fh.read();

        for (String line : arrayList) {
            items.add(lineToItemFunction.apply(line));
        }

        return items;
    }
}