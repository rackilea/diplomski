@Override
public void start( Stage stage )
{

    GridPane gp = new GridPane();
    Label l = new Label( "before" );
    Button b = new Button( "move" );

    b.setOnAction( ( e ) ->
    {
        int i = GridPane.getColumnIndex( l );
        System.out.println( "i = " + i );
        l.setText( "after" );
        GridPane.setColumnIndex( l, 2 );
    } );

    gp.add( l, 0, 0 );
    gp.add( b, 1, 1 );
    gp.setGridLinesVisible( true );
    gp.getColumnConstraints().addAll( new ColumnConstraints( 70 ), new ColumnConstraints( 70 ), new ColumnConstraints( 70 ) );

    final Scene scene = new Scene( gp, 400, 300 );

    stage.setScene( scene );
    stage.show();
}