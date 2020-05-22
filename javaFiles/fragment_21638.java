Platform.runLater(() -> {
    // clears current studentlist and adds the new list
    if (currentStudentList.getItems().size() != 0) 
        currentStudentList.getItems().clear();

    currentStudentList.getItems().addAll(tempCurrent);
});

Platform.runLater(() -> {
    // clears the allStudentList and adds the new list
    if (allStudentsList.getItems().size() != 0) 
        allStudentsList.getItems().clear();

    allStudentsList.getItems().addAll(tempAll);
});