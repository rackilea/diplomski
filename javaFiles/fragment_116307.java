double startKM;
double endKM;
try {
    startKM = Double.parseDouble(txtStartKM.getText());
    endKM = Double.parseDouble(txtEndKM.getText());
} catch (NumberFormatException e | NullPointerException e) {
    // the line above assumes java 7
    // recover
}

DrivingDetails details = new DrivingDetails(startKM, endKM,
        txtStartLocation.getText(),
        txtEndLocation.getText());

List<DrivingDetails> detailsList = new ArrayList<DrivingDetails>();
detailsList.add(details);