ISystemRegistry registry = SystemStartHere.getSystemRegistry();

SystemResourceChangeEvent event = new SystemResourceChangeEvent(this, 
    ISystemResourceChangeEvents.EVENT_REFRESH, yoursubsystem);

registry.fireEvent(event);