public class LifeCycle
{
  @PostContextCreate
  public void postContextCreate(IEclipseContext context, IEventBroker eventBroker)
  {
    ...

    eventBroker.subscribe(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE,
                          new AppStartupCompleteEventHandler(eventBroker, context));
  }
}


class AppStartupCompleteEventHandler implements EventHandler
{
 private IEventBroker _eventBroker;
 private IEclipseContext _context;


 AppStartupCompleteEventHandler(IEventBroker eventBroker, IEclipseContext context)
 {
   _eventBroker = eventBroker;
   _context = context;
 }

 @Override
 public void handleEvent(final Event event)
 {
   _eventBroker.unsubscribe(this);

   IWorkbench workbench = _context.get(IWorkbench.class);

   workbench.close();
 }
}