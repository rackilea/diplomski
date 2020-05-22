public class DefaultValidationHandler implements ValidationListener {

    private JTextField field;

    public DefaultValidationHandler(JTextField field) {
        this.field = field;
    }

    public JTextField getField() {
        return field;
    }

    @Override
    public void validationFailed() {
        getField().setBackground(Color.RED);
    }

    @Override
    public void validationPassed() {
        getField().setBackground(UIManager.getColor("TextField.background"));
    }

}