/**
     * Sets up a custom {@code SWT.MouseUp} event and fires it. This is needed because a {@code SWT.MouseDown} is consuming all
     * other events until a {@code SWT.MouseUp} event is fired. This means that it is not possible to get a e.g. 
     * {@code SWT.MouseEnter} event when entering a certain StyledText which is needed for selection. Therefore a custom {@code SWT.MouseUp} 
     * event is fired to simulate the releasing of the button on system level so that all other events can come through again. The real problem here
     * is to distinguish between the custom event for simulation and a normal event produced by the user. Firing the event via Display.post(Event)
     * does not fire the handed over event parameter. The system actually creates a new event instance. Therefore 2 criteria are used to distinguish the custom event:
     *  <ul>
     *      <ol>1. The selection can only be started by dragging a border control. 
     *          A {@code SWT.DragDetect} event starts the hole selection process. All events coming in before this event are ignored.</ol>
     *      <ol>2. The actual distinguishing of the {@code SWT.MouseUp} is performed on the cursor coordinates and the referenced/dragged {@code widget}.
     *          The dragging event has to be started on this widget.</ol>
     *  </ul>
     * @param the starting {@code SWT.DragDetect} event
     * @see #isCustomMouseUpEvent(Event)
     */
    private void fireCustomMouseUpEvent(Event dragDetectEvent){
        customMouseUpEvent = new Event();
        customMouseUpEvent.type = SWT.MouseUp;
        customMouseUpEvent.button = 1; //left mouse button
        customMouseUpEvent.widget = dragDetectEvent.widget;

        if(dragDetectEvent.widget instanceof Control){
            startingControl = (Control) dragDetectEvent.widget;
            //get cursor location relative to widget to be comparable later with the event fired by the system
            Point cursorLocation = startingControl.toControl(startingControl.getDisplay().getCursorLocation());
            customMouseUpEvent.x = cursorLocation.x;
            customMouseUpEvent.y = cursorLocation.y;
        }

        /*
         * note: set attributes like Event.data or Event.x are not present 
         * in the actually firing event. SWT or the system is creating a complete new
         * event instance without those manually added information.
         */
//      mouseUpEvent.data = SELECTION_START_EVENT_IDENTIFIER;
        if(dragDetectEvent.widget.getDisplay().post(customMouseUpEvent))
            System.out.println("custom MouseUp event fired!");
    }

    private boolean isCustomMouseUpEvent(Event event) {
        return customMouseUpEvent != null && event.widget == customMouseUpEvent.widget && 
                customMouseUpEvent.x == event.x && customMouseUpEvent.y == event.y;
    }