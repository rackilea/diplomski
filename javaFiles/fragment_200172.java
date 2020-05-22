@Override
public void start( Stage stage )
{
    Button b = new Button( "Close" );
    Label l = new Label( "Console" );

    StackPane sp = new StackPane( l, b );
    StackPane.setAlignment( l, Pos.CENTER_LEFT );
    StackPane.setAlignment( b, Pos.CENTER_RIGHT );

    TextArea area = new TextArea();
    VBox.setVgrow( area, Priority.ALWAYS );
    VBox box = new VBox( sp, area );

    Scene scene = new Scene( box, 800, 600 );

    stage.setScene( scene );
    stage.show();
}