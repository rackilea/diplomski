public void displayInformation(final Information information) {
    if (information.getType == InformationType.MESSAGE) {
        ....
    } else if (information.getType == InformationType.FAQ) {
        ....
    } else if (information.getType == InformationType.NEWS) {
        ....
    } else {
        // some error handling
}