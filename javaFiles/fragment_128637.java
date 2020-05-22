import java.util.concurrent.Executors;

private final Executor executor = Executors.newSingleThreadExecutor();

theButton.setOnAction(event ->
{
    try
    {
        ObservableList<Elements> toShow = FXCollections.observableArrayList();
        myTableView.setItems(toShow);

        ArrayList<String> strings = takeSomeStrings();

        for (String s: strings)
        {
            executor.execute(() -> {
                Elements el = new Elements(takeInfoFromTheWeb(s));
                Platform.runLater(() -> toShow.add(el));
            });
        }

    } catch (FileNotFoundException e)
    {
        e.printStackTrace();
    }
});