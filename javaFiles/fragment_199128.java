private final Map<TextField, String> fieldStrings = new LinkedHashMap<>();

@FXML
private void initialize() {
    fieldStrings.put(desShear, "Design shear");
    fieldStrings.put(boltSize, "Bolt size");
    fieldStrings.put(tensStrengthBolt, "Bolt strength");
    fieldStrings.put(noBolts, "Number of bolts");
    fieldStrings.put(shearPlanes, "Number of shear planes");
    fieldStrings.put(edgeDist, "Edge distance");
    fieldStrings.put(plyThick, "Ply thickness");
    fieldStrings.put(tensStrengthPly, "Ply strength");
    fieldStrings.put(phiBolt, "Bolt phi factor");
    fieldStrings.put(phiPly, "Ply phi factor");
}

private double getFieldValue(TextField field) {
    return Double.parseDouble(field.getText());
}

public void run(ActionEvent clickRun) {

    String errorField = fieldStrings.entrySet().stream()
                                     .filter(entry -> entry.getKey().getText().isBlank())
                                     .map(Map.Entry::getValue)
                                     .findFirst().orElse(null);

    if (errorField != null) {
        outputMsg.setText(errorField + " field is blank");
        return;
    }

    //Get field values
    double desSHEAR = getFieldValue(desShear);
    double boltSIZE = getFieldValue(boltSize);
    double tensStengthBOLT = getFieldValue(tensStrengthBolt);
    double noBOLTS = getFieldValue(noBolts);
    double shearPLANES = getFieldValue(shearPlanes);
    double edgeDIST = getFieldValue(edgeDist);
    double plyTHICK = getFieldValue(plyThick);
    double tensStrengthPLY = getFieldValue(tensStrengthPly);
    double phiBOLT = getFieldValue(phiBolt);
    double phiPLY = getFieldValue(phiPly);


    //Bolt shear calculation


}