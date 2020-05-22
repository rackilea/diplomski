static void store() {

            ......

            PREFS.put("check6", toleranceField.getText());

}

static void load() {

    ....

    toleranceField.setText(PREFS.get("check6", "default string value"));
}