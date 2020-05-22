@Optional
@Inject
public void appStartupComplete(@UIEventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) final Event event)
{
   ....
}