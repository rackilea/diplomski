private final ObjectProperty<B>  beanProp = new SimpleObjectProperty<>();
{
    beanProp.addListener( new ChangeListener<B>()
    {
        @Override
        public void changed( ObservableValue<? extends B> ob, B oldVal, B newVal )
        {
            setBean( newVal );
        }
    } );
}

public ObjectProperty<B> beanProperty()
{
    return beanProp; 
}