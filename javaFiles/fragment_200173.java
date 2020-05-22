@Override
public void start( Stage stage )
{
    Button b = new Button( "Close" );
    Label l = new Label( "Console" );
    Pane spacer = new Pane();

    HBox hBox = new HBox(l, spacer, b);
    HBox.setHgrow( spacer, Priority.ALWAYS);

    TextArea area = new TextArea();
    VBox.setVgrow( area, Priority.ALWAYS );
    VBox box = new VBox( hBox, area );

    Scene scene = new Scene( box, 800, 600 );

    stage.setScene( scene );
    stage.show();
}