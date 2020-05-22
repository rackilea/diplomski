public class FXMLManagedProducer {
    @Produces @FXMLManaged
    public NewsListView getFXMLManagedInstance() {
        return new NewsListView();
    }
}