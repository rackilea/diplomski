Button btn = new Button("Test");

    //default event handler
    btn.setOnMouseClicked(new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            System.out.println("hello");
        }
    });

    //store default event handler
    EventHandler<Event> oldHandler = (EventHandler<Event>) btn.getOnMouseClicked();

    //set new event handler
    btn.setOnMouseClicked(new EventHandler<Event>() {
        @Override
        public void handle(Event event) {
            System.out.println("test");
        }
    });

    //restore default event handler
    btn.setOnMouseClicked(oldHandler);