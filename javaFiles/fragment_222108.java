@Optional
@Inject
public void appStartupComplete(@UIEventTopic(UIEvents.UILifeCycle.APP_STARTUP_COMPLETE) org.osgi.service.event.Event event, 
                               MApplication app, EModelService modelService)
{
  // Find top level window

  MWindow window = (MWindow)modelService.find("main window id", app);

  IEclipseContext windowContext = window.getContext();

  windowContext.set(ISaveHandler.class, new SaveHandler());