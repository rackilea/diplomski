@Override
public boolean verify(JComponent input) {
    try {
        value = Double.parseDouble(field.getText());
        return model.isValid(value); // also check model
    } catch (NumberFormatException e) {
        return false;
    }
}