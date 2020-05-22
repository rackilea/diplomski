Event.sinkEvents(mWorkCompleted, Event.ONCHANGE);
        Event.setEventListener(mWorkCompleted, new EventListener() {

            @Override
            public void onBrowserEvent(Event event) {

            }
        });