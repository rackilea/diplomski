...
        Button button = new Button("Submit");
        pane.add(button, 0, 2);

        ValidationSupport vs = new ValidationSupport();
        vs.setErrorDecorationEnabled(false); // we don't want errors to bother us for now.
        vs.registerValidator(numberField, Validator.createRegexValidator("must be digits only!", "\\d*", Severity.ERROR));


        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vs.setErrorDecorationEnabled(true); // validate and show errors now!
            }
        });
        ...