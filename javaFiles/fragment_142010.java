GridPane gp = new GridPane();
        Button b = new Button("click");
        gp.add(b, 1, 1);
        b.setOnAction(e -> createLabel());

        ScrollPane sp = new ScrollPane(gp);

        container.add(sp); // where container is whatever node that'll contain the gridpane.