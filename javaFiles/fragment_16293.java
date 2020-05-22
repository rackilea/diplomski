private static final int STARTING_LOC = 0;
private Locations locations = new Locations();
private int loc;

private TextArea mainTextArea = new TextArea();
private TextField textField = new TextField();

public void initialize() {
    mainTextArea.setText("Welcome to adventure game!");
    moveTo(STARTING_LOC);

    textField.setOnKeyPressed(keyEvent -> {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            String direction = textField.getText().toUpperCase();
            Integer newLoc = getCurrentExits().get(direction);
            if (newLoc != null) {
                moveTo(newLoc);
            }

            textField.setText("");
        }
    });
}

private void moveTo(int newLoc) {
    this.loc = newLoc;
    mainTextArea.appendText(
        locations.getLocationsMap().get(loc).getDescription()
            + "\n In which direction would you like to go? \nAvailable directions: "
    );
    for (String exit : getCurrentExits().keySet()) {
        mainTextArea.appendText(exit + " ");
    }
}

private Map<String, Integer> getCurrentExits() {
    return locations.getLocationsMap().get(loc).getExits();
}