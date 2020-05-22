Scene scene=new Scene(cbTreeView);
    primaryStage.setScene(scene);
    primaryStage.show();

    // disable by name
    disableList.stream()
            .filter(w->w.getName().equals("03"))
            .findFirst().ifPresent(w->w.setDisabled(true));
    // disable by order
    disableList.get(7).setDisabled(true);