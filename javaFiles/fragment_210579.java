public class AlphabetGuess extends Application {
    private String vowels = "AEIOU";

    @Override
    public void start(Stage primaryStage) throws Exception {
        ObservableList<Text> alphabet = FXCollections.observableArrayList();

        for(char letter = 'A'; letter <= 'Z'; letter++){
            alphabet.add(new Text(String.valueOf(letter)));
        }

        HBox alphabetContainer = new HBox(5);
        alphabetContainer.setAlignment(Pos.CENTER);
        alphabetContainer.getChildren().addAll(alphabet);

        ToggleButton button = new ToggleButton("Listen for guess");
        button.setSelected(false);

        VBox root = new VBox(20, alphabetContainer, button);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 500, 100);
        scene.setOnKeyPressed(event -> {
            //If the button isn't selected, don't process the input
            if (event.getText().isEmpty() || !button.isSelected()) {
                return;
            }

            char userGuess = event.getText().toUpperCase().charAt(0);
            if ((userGuess < 'A' || userGuess > 'Z')) {
                return;
            }

            //This will cause letters A-Z to become 0-25 allowing the list to be indexed
            Text text = alphabet.get(userGuess - 'A');
            if (text.isStrikethrough()) {
                System.out.println(userGuess + " has already been guessed");
                return;
            } else {
                text.setFill(Color.BLUE);
                text.setStrikethrough(true);
                checkPhrase(userGuess);
            }
            //Un-select button which will cause this event to reject incoming keys
            button.setSelected(false);
        });

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void checkPhrase(char chosenLetter){
        //Handle the Hangman-like logic here
        boolean isVowel = vowels.indexOf(chosenLetter) >= 0;
        if (isVowel) {
            System.out.println("User provided a vowel");
        }
        //ToDo: Implement
    }
}