public class MessageDataTableModel
{

    private StringProperty timestampProperty = new SimpleStringProperty();

    public void setTimestamp( String timestamp ) {
        this.timestampProperty.set( timestamp );
    }

    public String getTimestamp() {
        return this.timestampProperty.get();
    }

    public StringProperty timestampProperty() {
        return this.timestampProperty;
    }
}