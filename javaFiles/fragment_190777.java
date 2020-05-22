/**
     * Called from dispatchEvent() under a correct AccessControlContext
     */
    private void dispatchEventImpl(final AWTEvent event, final Object src) {
        event.isPosted = true;
        if (event instanceof ActiveEvent) {
            // This could become the sole method of dispatching in time.
            setCurrentEventAndMostRecentTimeImpl(event);
            ((ActiveEvent)event).dispatch();
        } else if (src instanceof Component) {
            ((Component)src).dispatchEvent(event);
            event.dispatched();
        } else if (src instanceof MenuComponent) {
            ((MenuComponent)src).dispatchEvent(event);
        } else if (src instanceof TrayIcon) {
            ((TrayIcon)src).dispatchEvent(event);
        } else if (src instanceof AWTAutoShutdown) {
            if (noEvents()) {
                dispatchThread.stopDispatching();
            }
        } else {
            if (getEventLog().isLoggable(PlatformLogger.Level.FINE)) {
                getEventLog().fine("Unable to dispatch event: " + event);
            }
        }
    }