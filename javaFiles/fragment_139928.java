public static void stopStoringFiredEvents() {
    FxToolkitContext context = FxToolkit.toolkitContext();
    // reflectively access the private field of the context
    FiredEvents fired =(FiredEvents) FXUtils.invokeGetFieldValue(FxToolkitContext.class, context, "firedEvents");
    // stop recording
    fired.stopStoringFiredEvents();
}

/**
 * Updated hack, now reaaally dirty: need to manually clear the handler map :(
 */
public static void stopStoringFiredEvents(Stage stage) {
    // remove the event-logging filter
    stopStoringFiredEvents();
    // really cleanup: 
    // removing the filter only nulls the eventHandler in CompositeEventHandler
    // but does not remove the Composite from EventHandlerManager.handlerMap
    // as a result, handlerManager.dispatchCapturingEvent runs into the fixForSource
    // block which copies the event even though there is no filter
    WindowEventDispatcher windowDispatcher = (WindowEventDispatcher) stage.getEventDispatcher();
    EventHandlerManager manager = windowDispatcher.getEventHandlerManager();
    Map<?, ?> handlerMap = (Map<?, ?>) FXUtils.invokeGetFieldValue(EventHandlerManager.class, manager, "eventHandlerMap");
    handlerMap.clear();
}