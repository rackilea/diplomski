public class HomePage extends WebPage {

    public HomePage(final PageParameters parameters) {

        add( new Label( "label", parameters.getString( "param")));

        add( new ListView( "list", Arrays.asList( "foo", "bar") ) {
            @Override
            protected void populateItem(final ListItem item) {
                item.add( new Label( "label", "item model is "+item.getModelObject() ) );
                item.add( new AjaxEventBehavior( "onclick") {

                    @Override
                    protected void onEvent(AjaxRequestTarget target) {
                        PageParameters pp = new PageParameters( "param="+item.getModelObject() );
                        setResponsePage( new HomePage( pp ) );
                    }
                });

            }
        });
    }
}