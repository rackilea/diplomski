buttonCalculator.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Editable massInputStr = massInputText.getText();
        if (isEmpty(massInputStr) || isNotANumber(massInputStr)) {
            massInputText.setError("Please enter the mass value (example: 12.5)");
            return; // Prevent further execution
        }

        Editable heightStr = heightInputText.getText();
        if (isEmpty(heightStr)  || isNotANumber(heightStr)) {
            heightInputText.setError("Please enter a valid height (example: 1.75)");
            return; // Prevent further execution
        }

        double mass = Double.parseDouble(massInputStr.toString());
        double height = Double.parseDouble(heightStr.toString());
        double bmi = getMassData(mass, height);
        textResult.setText(df.format(bmi));
    }

    private boolean isEmpty(Editable editable) {
        return editable == null || editable.toString().trim().isEmpty();
    }

    private boolean isNotANumber(Editable editable) {
        return !editable.toString().trim().matches("\\d+(\\.\\d+)?");
    }
});