ComboBox<Duration> combo =  new ComboBox<>(
            FXCollections.observableArrayList(
                Duration.UNKNOWN,
                Duration.seconds(1),
                Duration.seconds(5),
                Duration.seconds(10),
                Duration.seconds(15)));

    combo.setCellFactory(lv -> createListCell());
    combo.setButtonCell(createListCell());

    combo.valueProperty().addListener((obs, oldValue, newValue) -> {
        if (newValue == null || newValue == Duration.UNKNOWN) {
            myService.cancel();
        } else {
            myService.setPeriod(newValue);
        }
    });