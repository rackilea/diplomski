class ClickHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent event) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, "Ouch"));
    }

}