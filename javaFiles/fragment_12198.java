Button button = new Button("Click Me");
    button.setOnAction(event -> {
        Object node = event.getSource(); //returns the object that generated the event
        System.out.println(node instanceof Button); //prints true. demonstrates the source is a Button
        //since the returned object is a Button you can cast it to one
        Button b = (Button)node;
        System.out.println(b.getText());//prints out Click Me
    });