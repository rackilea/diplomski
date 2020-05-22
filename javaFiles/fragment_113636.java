public class Simple extends AnchorPane implements Initializable{

    private static final int DEFAULT_VALUE = -10 ;

    public Simple(@NamedArg("value") int value){
        //Loads the FXML sheet
        FXMLLoader fxmlLoader = new FXMLLoader( getClass().getResource( "Simple.fxml") );
        fxmlLoader.setRoot(this); 
        fxmlLoader.setController(this);

        // set value, avoiding property creation if default...
        if (value != DEFAULT_VALUE) {
            setValue(value);
        }

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

        System.out.println( "Constructor: " + getValue() );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println( "Init: " + getValue() );
    }


    @FXML protected void printValue(ActionEvent ae){
        System.out.println( "Button: " + getValue() );
    }

    //Editor field for the  value (helps scene builder to render it)
    IntegerProperty valueProperty;
    public final void setValue(Integer value){
        valueProperty().setValue(value);
    }
    public final Integer getValue(){
        return valueProperty == null ? DEFAULT_VALUE : valueProperty.get();
    }
    public final IntegerProperty valueProperty() {
        if( valueProperty == null )
            valueProperty = new SimpleIntegerProperty(DEFAULT_VALUE);
        return valueProperty;
    }
}