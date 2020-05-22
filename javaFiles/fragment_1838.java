add(new AbstractAjaxTimerBehavior(Duration.seconds(10)) 
{
    @Override
    protected final void onTimer(AjaxRequestTarget target) 
    {   //createContainer() generates the views and container.
        target.add(createContainer()); 
    }
}