public class FXMLDocumentController implements Initializable
{
    @FXML
    private VBox parentMenuVBox;

    private final Background focusBackground = new Background( new BackgroundFill( Color.web( "#000000" ), CornerRadii.EMPTY, Insets.EMPTY ) );
    private final Background unfocusBackground = new Background( new BackgroundFill( Color.web( "#F4F4F4" ), CornerRadii.EMPTY, Insets.EMPTY ) );

    @FXML
    private void handleSelectMenus( MouseEvent event )
    {
        // Set unfocusBackground for all child vboxes
        for ( Node child : parentMenuVBox.getChildren() )
        {
            VBox vb = ( VBox ) child;
            vb.setBackground( unfocusBackground );
        }

        // and set focusBackground for only selected one
        VBox selected = ( VBox ) event.getSource();
        selected.setBackground( focusBackground );

        System.out.println( "Menu clicked" );
    }

    @Override
    public void initialize( URL url, ResourceBundle rb )
    {
    }

}