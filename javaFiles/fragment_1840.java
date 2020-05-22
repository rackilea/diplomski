public WeerPanel(String id) throws IOException 
{
  super(id);

  final WebMarkupContainer container = createContainer();

  add(new AbstractAjaxTimerBehavior(Duration.seconds(10)) 
  {
    @Override
    protected final void onTimer(AjaxRequestTarget target) 
    {   //createContainer() generates the views and container.
        container.addOrReplace(createContainer());
    }
  }
}