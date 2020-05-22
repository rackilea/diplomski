private Scene assets(Stage primaryStage){
                Scene assets;
                GridPane gp = new GridPane();
                gp.setVgap(0);
                //gp.setPadding(new Insets(25, 0, 25, 25));

                Text title = new Text("Assets");
                title.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                gp.add(title, 0, 0);

                Text description = new Text("Please select all assets you would like to include in your budget");
                gp.add(description, 0, 1);

                String [] optionsString = new String []{"A", "B", "C", "D", "E", "F"};
                HBox checkboxContainer = new HBox();
                checkboxContainer.setPadding(new Insets(5, 5, 5, 5));
                checkboxContainer.setSpacing(20);

                for (int i = 0; i < optionsString.length; i++) {
                    final int column = i;
                    final int row = i;
                    String option = optionsString[i];
                    CheckBox checkBox = new CheckBox(option);
                    ChoiceBox<Integer> choice = new ChoiceBox<>();
                    Label label = new Label("How many " + optionsString[i] + " options do you have?");
                    choice.getItems().addAll(1, 2, 3, 4, 5);

                    HBox choiceContainer = new HBox(label, choice);

                    checkBox.selectedProperty().addListener((o, oldValue, newValue) -> {
                        if (newValue) {
                            gp.add(choiceContainer, 0, row + 4);
                        } else {
                            gp.getChildren().remove(choiceContainer);
                        }
                    });
                    checkboxContainer.getChildren().add(checkBox);
                }
                gp.add(checkboxContainer, 0, 2);

                assets = new Scene (gp, 1280, 720);

                return assets;
            }