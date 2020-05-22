scrollBar.addEventFilter(ScrollEvent.SCROLL, new EventHandler<ScrollEvent>() {
            @Override
            public void handle(ScrollEvent event) {
                event.consume();
                Node target = tableScrollBar;
                ScrollEvent retargettedScrollEvent = new ScrollEvent(target, target, event.getEventType(),
                        event.getX(), event.getY(), event.getScreenX(), event.getScreenY(), event.isShiftDown(),
                        event.isControlDown(), event.isAltDown(), event.isMetaDown(), event.isDirect(),
                        event.isInertia(), event.getDeltaX(), event.getDeltaY(), event.getTotalDeltaX(),
                        event.getTotalDeltaY(), event.getTextDeltaXUnits(), event.getTextDeltaX(),
                        event.getTextDeltaYUnits(), event.getTextDeltaY(), event.getTouchCount(),
                        event.getPickResult());
                Event.fireEvent(target, retargettedScrollEvent);
            }
        });