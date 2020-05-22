@Override
public void start( Stage stage )
{
    ScrollPane scrollPane = new ScrollPane( new Printable( new Label( "looong loooong loooooong looooong loooong text" ) ) );
    stage.setScene( new Scene( scrollPane ) );
    stage.show();
}


class Printable extends VBox
{
    public Printable( Node... children )
    {
        super( children );

        Printable me = this;
        this.widthProperty().addListener( new ChangeListener<Number>()
        {
            @Override
            public void changed( ObservableValue<? extends Number> observable, Number oldValue, Number newValue )
            {
                double maxWidth = 100.0;
                double width = newValue.doubleValue();
                if ( width > maxWidth )
                {
                    double widthFrac = maxWidth / width;
                    me.setScaleX( widthFrac );
                }
            }
        } );
    }
}