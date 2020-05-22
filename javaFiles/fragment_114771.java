gen.setOnAction(new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent e) {

            // combination.init();
            String generated = setPassword();
            area.setText(generated);

        }

    });