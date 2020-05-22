createDataButton.setDisable(false);
if (imageEnemy.getImage() == null) {
    createDataButton.setDisable(true);
} else {
    List<TextField> textFields = Arrays.asList(nameEnemy, experienceEnemy, goldEnemy, attackEnemy)
    for (TextField field : textFields) {
        if (field.getText().isEmpty()) {
            createDataButton.setDisable(true);
            break;
        }
    }
}