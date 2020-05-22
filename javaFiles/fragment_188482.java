try {
    float input = Float.valueOf(txtInput.getText());
    float output = 0;

    switch (cmbChoose.getSelectedIndex()) {
        case 0:
            output = input * 5; break;
        case 1:
            output = input + 10; break;
        case 2:
            output = input * 1.05f;
    }

    txtResult.setText(String.valueOf(output));
} catch (Exception e) {
    txtResult.setText("[Error]");
}