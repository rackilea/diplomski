class ButtonPanel extends JPanel implements ActionListener {
    private TextRetriever textRetriever;

    public ButtonPanel(TextRetriever textRetriever) {
       this.textRetriever = textRetriever
       ...
    }

    public void printTextOnConsole() {
        String text = textRetriever.getText();
    }
}