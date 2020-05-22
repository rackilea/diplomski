if (!theInput.matches("[2-9]+"))
{
    Alert error2 = new Alert(AlertType.ERROR);
    error2.setTitle("Invalid digit");
    error2.setHeaderText("INVALID DIGIT!");
    error2.setContentText("Please enter three digits ranging from 2 through 9");
    error2.showAndWait();
}
else
{
    calculateMnemonics();
}