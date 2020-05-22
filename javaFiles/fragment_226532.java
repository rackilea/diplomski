public void eventDispatched(AWTEvent e) { 
  if (e instanceof MouseEvent) {
    MouseEvent  me=(MouseEvent)e;
  } 
}

long KEY_EVENTS = AWTEvent.KEY_EVENT_MASK;
long MOUSE_EVENTS = AWTEvent.MOUSE_EVENT_MASK;
long MOUSE_MOTION_EVENTS = AWTEvent.MOUSE_MOTION_EVENT_MASK;